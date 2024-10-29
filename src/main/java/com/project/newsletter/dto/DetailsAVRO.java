/**
 * Autogenerated by Avro
 *
 * DO NOT EDIT DIRECTLY
 */
package com.project.newsletter.dto;

import org.apache.avro.specific.SpecificData;
import org.apache.avro.message.BinaryMessageEncoder;
import org.apache.avro.message.BinaryMessageDecoder;
import org.apache.avro.message.SchemaStore;

@SuppressWarnings("all")
@org.apache.avro.specific.AvroGenerated
public class DetailsAVRO extends org.apache.avro.specific.SpecificRecordBase implements org.apache.avro.specific.SpecificRecord {
  private static final long serialVersionUID = 7874595836408215971L;
  public static final org.apache.avro.Schema SCHEMA$ = new org.apache.avro.Schema.Parser().parse("{\"type\":\"record\",\"name\":\"DetailsAVRO\",\"namespace\":\"com.project.newsletter.dto\",\"fields\":[{\"name\":\"newsletter\",\"type\":{\"type\":\"record\",\"name\":\"NewsletterObject\",\"fields\":[{\"name\":\"title\",\"type\":\"string\"},{\"name\":\"description\",\"type\":\"string\"},{\"name\":\"publishedBy\",\"type\":\"string\"},{\"name\":\"category\",\"type\":\"string\"}]}},{\"name\":\"users\",\"type\":{\"type\":\"array\",\"items\":{\"type\":\"record\",\"name\":\"UserObject\",\"fields\":[{\"name\":\"name\",\"type\":\"string\"},{\"name\":\"email\",\"type\":\"string\"}]}}}]}");
  public static org.apache.avro.Schema getClassSchema() { return SCHEMA$; }

  private static SpecificData MODEL$ = new SpecificData();

  private static final BinaryMessageEncoder<DetailsAVRO> ENCODER =
      new BinaryMessageEncoder<DetailsAVRO>(MODEL$, SCHEMA$);

  private static final BinaryMessageDecoder<DetailsAVRO> DECODER =
      new BinaryMessageDecoder<DetailsAVRO>(MODEL$, SCHEMA$);

  /**
   * Return the BinaryMessageDecoder instance used by this class.
   */
  public static BinaryMessageDecoder<DetailsAVRO> getDecoder() {
    return DECODER;
  }

  /**
   * Create a new BinaryMessageDecoder instance for this class that uses the specified {@link SchemaStore}.
   * @param resolver a {@link SchemaStore} used to find schemas by fingerprint
   */
  public static BinaryMessageDecoder<DetailsAVRO> createDecoder(SchemaStore resolver) {
    return new BinaryMessageDecoder<DetailsAVRO>(MODEL$, SCHEMA$, resolver);
  }

  /** Serializes this DetailsAVRO to a ByteBuffer. */
  public java.nio.ByteBuffer toByteBuffer() throws java.io.IOException {
    return ENCODER.encode(this);
  }

  /** Deserializes a DetailsAVRO from a ByteBuffer. */
  public static DetailsAVRO fromByteBuffer(
      java.nio.ByteBuffer b) throws java.io.IOException {
    return DECODER.decode(b);
  }

  @Deprecated public com.project.newsletter.dto.NewsletterObject newsletter;
  @Deprecated public java.util.List<com.project.newsletter.dto.UserObject> users;

  /**
   * Default constructor.  Note that this does not initialize fields
   * to their default values from the schema.  If that is desired then
   * one should use <code>newBuilder()</code>.
   */
  public DetailsAVRO() {}

  /**
   * All-args constructor.
   * @param newsletter The new value for newsletter
   * @param users The new value for users
   */
  public DetailsAVRO(com.project.newsletter.dto.NewsletterObject newsletter, java.util.List<com.project.newsletter.dto.UserObject> users) {
    this.newsletter = newsletter;
    this.users = users;
  }

  public org.apache.avro.Schema getSchema() { return SCHEMA$; }
  // Used by DatumWriter.  Applications should not call.
  public java.lang.Object get(int field$) {
    switch (field$) {
    case 0: return newsletter;
    case 1: return users;
    default: throw new org.apache.avro.AvroRuntimeException("Bad index");
    }
  }

  // Used by DatumReader.  Applications should not call.
  @SuppressWarnings(value="unchecked")
  public void put(int field$, java.lang.Object value$) {
    switch (field$) {
    case 0: newsletter = (com.project.newsletter.dto.NewsletterObject)value$; break;
    case 1: users = (java.util.List<com.project.newsletter.dto.UserObject>)value$; break;
    default: throw new org.apache.avro.AvroRuntimeException("Bad index");
    }
  }

  /**
   * Gets the value of the 'newsletter' field.
   * @return The value of the 'newsletter' field.
   */
  public com.project.newsletter.dto.NewsletterObject getNewsletter() {
    return newsletter;
  }

  /**
   * Sets the value of the 'newsletter' field.
   * @param value the value to set.
   */
  public void setNewsletter(com.project.newsletter.dto.NewsletterObject value) {
    this.newsletter = value;
  }

  /**
   * Gets the value of the 'users' field.
   * @return The value of the 'users' field.
   */
  public java.util.List<com.project.newsletter.dto.UserObject> getUsers() {
    return users;
  }

  /**
   * Sets the value of the 'users' field.
   * @param value the value to set.
   */
  public void setUsers(java.util.List<com.project.newsletter.dto.UserObject> value) {
    this.users = value;
  }

  /**
   * Creates a new DetailsAVRO RecordBuilder.
   * @return A new DetailsAVRO RecordBuilder
   */
  public static com.project.newsletter.dto.DetailsAVRO.Builder newBuilder() {
    return new com.project.newsletter.dto.DetailsAVRO.Builder();
  }

  /**
   * Creates a new DetailsAVRO RecordBuilder by copying an existing Builder.
   * @param other The existing builder to copy.
   * @return A new DetailsAVRO RecordBuilder
   */
  public static com.project.newsletter.dto.DetailsAVRO.Builder newBuilder(com.project.newsletter.dto.DetailsAVRO.Builder other) {
    return new com.project.newsletter.dto.DetailsAVRO.Builder(other);
  }

  /**
   * Creates a new DetailsAVRO RecordBuilder by copying an existing DetailsAVRO instance.
   * @param other The existing instance to copy.
   * @return A new DetailsAVRO RecordBuilder
   */
  public static com.project.newsletter.dto.DetailsAVRO.Builder newBuilder(com.project.newsletter.dto.DetailsAVRO other) {
    return new com.project.newsletter.dto.DetailsAVRO.Builder(other);
  }

  /**
   * RecordBuilder for DetailsAVRO instances.
   */
  public static class Builder extends org.apache.avro.specific.SpecificRecordBuilderBase<DetailsAVRO>
    implements org.apache.avro.data.RecordBuilder<DetailsAVRO> {

    private com.project.newsletter.dto.NewsletterObject newsletter;
    private com.project.newsletter.dto.NewsletterObject.Builder newsletterBuilder;
    private java.util.List<com.project.newsletter.dto.UserObject> users;

    /** Creates a new Builder */
    private Builder() {
      super(SCHEMA$);
    }

    /**
     * Creates a Builder by copying an existing Builder.
     * @param other The existing Builder to copy.
     */
    private Builder(com.project.newsletter.dto.DetailsAVRO.Builder other) {
      super(other);
      if (isValidValue(fields()[0], other.newsletter)) {
        this.newsletter = data().deepCopy(fields()[0].schema(), other.newsletter);
        fieldSetFlags()[0] = true;
      }
      if (other.hasNewsletterBuilder()) {
        this.newsletterBuilder = com.project.newsletter.dto.NewsletterObject.newBuilder(other.getNewsletterBuilder());
      }
      if (isValidValue(fields()[1], other.users)) {
        this.users = data().deepCopy(fields()[1].schema(), other.users);
        fieldSetFlags()[1] = true;
      }
    }

    /**
     * Creates a Builder by copying an existing DetailsAVRO instance
     * @param other The existing instance to copy.
     */
    private Builder(com.project.newsletter.dto.DetailsAVRO other) {
            super(SCHEMA$);
      if (isValidValue(fields()[0], other.newsletter)) {
        this.newsletter = data().deepCopy(fields()[0].schema(), other.newsletter);
        fieldSetFlags()[0] = true;
      }
      this.newsletterBuilder = null;
      if (isValidValue(fields()[1], other.users)) {
        this.users = data().deepCopy(fields()[1].schema(), other.users);
        fieldSetFlags()[1] = true;
      }
    }

    /**
      * Gets the value of the 'newsletter' field.
      * @return The value.
      */
    public com.project.newsletter.dto.NewsletterObject getNewsletter() {
      return newsletter;
    }

    /**
      * Sets the value of the 'newsletter' field.
      * @param value The value of 'newsletter'.
      * @return This builder.
      */
    public com.project.newsletter.dto.DetailsAVRO.Builder setNewsletter(com.project.newsletter.dto.NewsletterObject value) {
      validate(fields()[0], value);
      this.newsletterBuilder = null;
      this.newsletter = value;
      fieldSetFlags()[0] = true;
      return this;
    }

    /**
      * Checks whether the 'newsletter' field has been set.
      * @return True if the 'newsletter' field has been set, false otherwise.
      */
    public boolean hasNewsletter() {
      return fieldSetFlags()[0];
    }

    /**
     * Gets the Builder instance for the 'newsletter' field and creates one if it doesn't exist yet.
     * @return This builder.
     */
    public com.project.newsletter.dto.NewsletterObject.Builder getNewsletterBuilder() {
      if (newsletterBuilder == null) {
        if (hasNewsletter()) {
          setNewsletterBuilder(com.project.newsletter.dto.NewsletterObject.newBuilder(newsletter));
        } else {
          setNewsletterBuilder(com.project.newsletter.dto.NewsletterObject.newBuilder());
        }
      }
      return newsletterBuilder;
    }

    /**
     * Sets the Builder instance for the 'newsletter' field
     * @param value The builder instance that must be set.
     * @return This builder.
     */
    public com.project.newsletter.dto.DetailsAVRO.Builder setNewsletterBuilder(com.project.newsletter.dto.NewsletterObject.Builder value) {
      clearNewsletter();
      newsletterBuilder = value;
      return this;
    }

    /**
     * Checks whether the 'newsletter' field has an active Builder instance
     * @return True if the 'newsletter' field has an active Builder instance
     */
    public boolean hasNewsletterBuilder() {
      return newsletterBuilder != null;
    }

    /**
      * Clears the value of the 'newsletter' field.
      * @return This builder.
      */
    public com.project.newsletter.dto.DetailsAVRO.Builder clearNewsletter() {
      newsletter = null;
      newsletterBuilder = null;
      fieldSetFlags()[0] = false;
      return this;
    }

    /**
      * Gets the value of the 'users' field.
      * @return The value.
      */
    public java.util.List<com.project.newsletter.dto.UserObject> getUsers() {
      return users;
    }

    /**
      * Sets the value of the 'users' field.
      * @param value The value of 'users'.
      * @return This builder.
      */
    public com.project.newsletter.dto.DetailsAVRO.Builder setUsers(java.util.List<com.project.newsletter.dto.UserObject> value) {
      validate(fields()[1], value);
      this.users = value;
      fieldSetFlags()[1] = true;
      return this;
    }

    /**
      * Checks whether the 'users' field has been set.
      * @return True if the 'users' field has been set, false otherwise.
      */
    public boolean hasUsers() {
      return fieldSetFlags()[1];
    }


    /**
      * Clears the value of the 'users' field.
      * @return This builder.
      */
    public com.project.newsletter.dto.DetailsAVRO.Builder clearUsers() {
      users = null;
      fieldSetFlags()[1] = false;
      return this;
    }

    @Override
    @SuppressWarnings("unchecked")
    public DetailsAVRO build() {
      try {
        DetailsAVRO record = new DetailsAVRO();
        if (newsletterBuilder != null) {
          record.newsletter = this.newsletterBuilder.build();
        } else {
          record.newsletter = fieldSetFlags()[0] ? this.newsletter : (com.project.newsletter.dto.NewsletterObject) defaultValue(fields()[0]);
        }
        record.users = fieldSetFlags()[1] ? this.users : (java.util.List<com.project.newsletter.dto.UserObject>) defaultValue(fields()[1]);
        return record;
      } catch (java.lang.Exception e) {
        throw new org.apache.avro.AvroRuntimeException(e);
      }
    }
  }

  @SuppressWarnings("unchecked")
  private static final org.apache.avro.io.DatumWriter<DetailsAVRO>
    WRITER$ = (org.apache.avro.io.DatumWriter<DetailsAVRO>)MODEL$.createDatumWriter(SCHEMA$);

  @Override public void writeExternal(java.io.ObjectOutput out)
    throws java.io.IOException {
    WRITER$.write(this, SpecificData.getEncoder(out));
  }

  @SuppressWarnings("unchecked")
  private static final org.apache.avro.io.DatumReader<DetailsAVRO>
    READER$ = (org.apache.avro.io.DatumReader<DetailsAVRO>)MODEL$.createDatumReader(SCHEMA$);

  @Override public void readExternal(java.io.ObjectInput in)
    throws java.io.IOException {
    READER$.read(this, SpecificData.getDecoder(in));
  }

}
