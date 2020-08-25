package org.sirix.access.trx.node.json;

import org.sirix.access.trx.node.NodeFactory;
import org.sirix.node.DeweyIDNode;
import org.sirix.node.SirixDeweyID;
import org.sirix.node.json.*;

import javax.annotation.Nonnegative;
import javax.annotation.Nonnull;

/**
 * Node factory for creating nodes.
 *
 * @author Johannes Lichtenberger
 *
 */
public interface JsonNodeFactory extends NodeFactory {
  /**
   * Create a {@link ArrayNode}.
   *
   * @param parentKey parent node key
   * @param leftSibKey left sibling key
   * @param rightSibKey right sibling key
   * @param pathNodeKey the path node key
   */
  ArrayNode createJsonArrayNode(@Nonnegative long parentKey, long leftSibKey, long rightSibKey, long pathNodeKey, SirixDeweyID id);

  /**
   * Create a {@link ObjectNode}.
   *
   * @param parentKey parent node key
   * @param leftSibKey left sibling key
   * @param rightSibKey right sibling key
   */
  ObjectNode createJsonObjectNode(@Nonnegative long parentKey, long leftSibKey, long rightSibKey, SirixDeweyID id);

  /**
   * Create a {@link ObjectKeyNode}.
   *
   * @param parentKey parent node key
   * @param leftSibKey left sibling key
   * @param rightSibKey right sibling key
   * @param pathNodeKey path node key of node
   * @param name the name of the key
   * @param objectValueKey the value of the object key value
   */
  ObjectKeyNode createJsonObjectKeyNode(@Nonnegative long parentKey, long leftSibKey, long rightSibKey,
      long pathNodeKey, String name, long objectValueKey, SirixDeweyID id);

  /**
   * Create a {@link StringNode}.
   *
   * @param parentKey parent node key
   * @param leftSibKey left sibling key
   * @param rightSibKey right sibling key
   * @param value the value to store
   * @param isCompressed {@code true}, if the value is compressed, {@code false} otherwise
   */
  StringNode createJsonStringNode(@Nonnegative long parentKey, long leftSibKey, long rightSibKey, byte[] value,
      boolean isCompressed, SirixDeweyID id);

  /**
   * Create a {@link BooleanNode}.
   *
   * @param parentKey parent node key
   * @param leftSibKey left sibling key
   * @param rightSibKey right sibling key
   * @param boolValue the boolean value
   */
  BooleanNode createJsonBooleanNode(@Nonnegative long parentKey, long leftSibKey, long rightSibKey, boolean boolValue, SirixDeweyID id);

  /**
   * Create a {@link NumberNode}.
   *
   * @param parentKey parent node key
   * @param leftSibKey left sibling key
   * @param rightSibKey right sibling key
   * @param value the number value
   */
  NumberNode createJsonNumberNode(@Nonnegative long parentKey, long leftSibKey, long rightSibKey, Number value, SirixDeweyID id);

  /**
   * Create a {@link NullNode}.
   *
   * @param parentKey parent node key
   * @param leftSibKey left sibling key
   * @param rightSibKey right sibling key
   */
  NullNode createJsonNullNode(@Nonnegative long parentKey, long leftSibKey, long rightSibKey, SirixDeweyID id);

  /**
   * Create a {@link StringNode}.
   *
   * @param parentKey parent node key
   * @param value the value to store
   * @param isCompressed {@code true}, if the value is compressed, {@code false} otherwise
   */
  ObjectStringNode createJsonObjectStringNode(@Nonnegative long parentKey, byte[] value,
      boolean isCompressed, SirixDeweyID id);

  /**
   * Create a {@link ObjectBooleanNode}.
   *
   * @param parentKey parent node key
   * @param boolValue the boolean value
   */
  ObjectBooleanNode createJsonObjectBooleanNode(@Nonnegative long parentKey, boolean boolValue, SirixDeweyID id);

  /**
   * Create a {@link NumberNode}.
   *
   * @param parentKey parent node key
   * @param value the number value
   */
  ObjectNumberNode createJsonObjectNumberNode(@Nonnegative long parentKey, Number value, SirixDeweyID id);

  /**
   * Create a {@link NullNode}.
   *
   * @param parentKey parent node key
   */
  ObjectNullNode createJsonObjectNullNode(@Nonnegative long parentKey, SirixDeweyID id);

  /**
   * Create a {@link DeweyIDNode}.
   *
   * @param nodeKey node key
   */
  DeweyIDNode createDeweyIdNode(@Nonnegative long nodeKey, @Nonnull SirixDeweyID id);
}
