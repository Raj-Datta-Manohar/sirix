package io.sirix.query.stream.node;

import io.brackit.query.jdm.Stream;
import org.roaringbitmap.longlong.PeekableLongIterator;
import io.sirix.api.xml.XmlNodeReadOnlyTrx;
import io.sirix.index.redblacktree.keyvalue.NodeReferences;
import io.sirix.query.node.XmlDBCollection;
import io.sirix.query.node.XmlDBNode;

import java.util.Iterator;

import static java.util.Objects.requireNonNull;

public final class SirixNodeKeyStream implements Stream<XmlDBNode> {

  private final Iterator<NodeReferences> iter;

  private final XmlDBCollection collection;

  private final XmlNodeReadOnlyTrx rtx;

  private PeekableLongIterator nodeKeyIterator;

  public SirixNodeKeyStream(final Iterator<NodeReferences> iter, final XmlDBCollection collection,
      final XmlNodeReadOnlyTrx rtx) {
    this.iter = requireNonNull(iter);
    this.collection = requireNonNull(collection);
    this.rtx = requireNonNull(rtx);
  }

  @Override
  public XmlDBNode next() {
    if (nodeKeyIterator != null && nodeKeyIterator.hasNext()) {
      var nodeKey = nodeKeyIterator.next();
      rtx.moveTo(nodeKey);
      return new XmlDBNode(rtx, collection);
    }
    while (iter.hasNext()) {
      final NodeReferences nodeReferences = iter.next();
      nodeKeyIterator = nodeReferences.getNodeKeys().getLongIterator();
      if (nodeKeyIterator.hasNext()) {
        var nodeKey = nodeKeyIterator.next();
        rtx.moveTo(nodeKey);
        return new XmlDBNode(rtx, collection);
      }
    }
    return null;
  }

  @Override
  public void close() {}

}
