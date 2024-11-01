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
public class NewsletterObject extends org.apache.avro.specific.SpecificRecordBase implements org.apache.avro.specific.SpecificRecord {
  private static final long serialVersionUID = 7071575479673268646L;
  public static final org.apache.avro.Schema SCHEMA$ = new org.apache.avro.Schema.Parser().parse("{\"type\":\"record\",\"name\":\"NewsletterObject\",\"namespace\":\"com.project.newsletter.dto\",\"fields\":[{\"name\":\"title\",\"type\":\"string\"},{\"name\":\"description\",\"type\":\"string\"},{\"name\":\"publishedBy\",\"type\":\"string\"},{\"name\":\"category\",\"type\":\"string\"}]}");
  public static org.apache.avro.Schema getClassSchema() { return SCHEMA$; }

  private static SpecificData MODEL$ = new SpecificData();

  private static final BinaryMessageEncoder<NewsletterObject> ENCODER =
      new BinaryMessageEncoder<NewsletterObject>(MODEL$, SCHEMA$);

  private static final BinaryMessageDecoder<NewsletterObject> DECODER =
      new BinaryMessageDecoder<NewsletterObject>(MODEL$, SCHEMA$);

  /**
   * Return the BinaryMessageDecoder instance used by this class.
   */
  public static BinaryMessageDecoder<NewsletterObject> getDecoder() {
    return DECODER;
  }

  /**
   * Create a new BinaryMessageDecoder instance for this class that uses the specified {@link SchemaStore}.
   * @param resolver a {@link SchemaStore} used to find schemas by fingerprint
   */
  public static BinaryMessageDecoder<NewsletterObject> createDecoder(SchemaStore resolver) {
    return new BinaryMessageDecoder<NewsletterObject>(MODEL$, SCHEMA$, resolver);
  }

  /** Serializes this NewsletterObject to a ByteBuffer. */
  public java.nio.ByteBuffer toByteBuffer() throws java.io.IOException {
    return ENCODER.encode(this);
  }

  /** Deserializes a NewsletterObject from a ByteBuffer. */
  public static NewsletterObject fromByteBuffer(
      java.nio.ByteBuffer b) throws java.io.IOException {
    return DECODER.decode(b);
  }

  @Deprecated public java.lang.CharSequence title;
  @Deprecated public java.lang.CharSequence description;
  @Deprecated public java.lang.CharSequence publishedBy;
  @Deprecated public java.lang.CharSequence category;

  /**
   * Default constructor.  Note that this does not initialize fields
   * to their default values from the schema.  If that is desired then
   * one should use <code>newBuilder()</code>.
   */
  public NewsletterObject() {}

  /**
   * All-args constructor.
   * @param title The new value for title
   * @param description The new value for description
   * @param publishedBy The new value for publishedBy
   * @param category The new value for category
   */
  public NewsletterObject(java.lang.CharSequence title, java.lang.CharSequence description, java.lang.CharSequence publishedBy, java.lang.CharSequence category) {
    this.title = title;
    this.description = description;
    this.publishedBy = publishedBy;
    this.category = category;
  }

  public org.apache.avro.Schema getSchema() { return SCHEMA$; }
  // Used by DatumWriter.  Applications should not call.
  public java.lang.Object get(int field$) {
    switch (field$) {
    case 0: return title;
    case 1: return description;
    case 2: return publishedBy;
    case 3: return category;
    default: throw new org.apache.avro.AvroRuntimeException("Bad index");
    }
  }

  // Used by DatumReader.  Applications should not call.
  @SuppressWarnings(value="unchecked")
  public void put(int field$, java.lang.Object value$) {
    switch (field$) {
    case 0: title = (java.lang.CharSequence)value$; break;
    case 1: description = (java.lang.CharSequence)value$; break;
    case 2: publishedBy = (java.lang.CharSequence)value$; break;
    case 3: category = (java.lang.CharSequence)value$; break;
    default: throw new org.apache.avro.AvroRuntimeException("Bad index");
    }
  }

  /**
   * Gets the value of the 'title' field.
   * @return The value of the 'title' field.
   */
  public java.lang.CharSequence getTitle() {
    return title;
  }

  /**
   * Sets the value of the 'title' field.
   * @param value the value to set.
   */
  public void setTitle(java.lang.CharSequence value) {
    this.title = value;
  }

  /**
   * Gets the value of the 'description' field.
   * @return The value of the 'description' field.
   */
  public java.lang.CharSequence getDescription() {
    return description;
  }

  /**
   * Sets the value of the 'description' field.
   * @param value the value to set.
   */
  public void setDescription(java.lang.CharSequence value) {
    this.description = value;
  }

  /**
   * Gets the value of the 'publishedBy' field.
   * @return The value of the 'publishedBy' field.
   */
  public java.lang.CharSequence getPublishedBy() {
    return publishedBy;
  }

  /**
   * Sets the value of the 'publishedBy' field.
   * @param value the value to set.
   */
  public void setPublishedBy(java.lang.CharSequence value) {
    this.publishedBy = value;
  }

  /**
   * Gets the value of the 'category' field.
   * @return The value of the 'category' field.
   */
  public java.lang.CharSequence getCategory() {
    return category;
  }

  /**
   * Sets the value of the 'category' field.
   * @param value the value to set.
   */
  public void setCategory(java.lang.CharSequence value) {
    this.category = value;
  }

  /**
   * Creates a new NewsletterObject RecordBuilder.
   * @return A new NewsletterObject RecordBuilder
   */
  public static com.project.newsletter.dto.NewsletterObject.Builder newBuilder() {
    return new com.project.newsletter.dto.NewsletterObject.Builder();
  }

  /**
   * Creates a new NewsletterObject RecordBuilder by copying an existing Builder.
   * @param other The existing builder to copy.
   * @return A new NewsletterObject RecordBuilder
   */
  public static com.project.newsletter.dto.NewsletterObject.Builder newBuilder(com.project.newsletter.dto.NewsletterObject.Builder other) {
    return new com.project.newsletter.dto.NewsletterObject.Builder(other);
  }

  /**
   * Creates a new NewsletterObject RecordBuilder by copying an existing NewsletterObject instance.
   * @param other The existing instance to copy.
   * @return A new NewsletterObject RecordBuilder
   */
  public static com.project.newsletter.dto.NewsletterObject.Builder newBuilder(com.project.newsletter.dto.NewsletterObject other) {
    return new com.project.newsletter.dto.NewsletterObject.Builder(other);
  }

  /**
   * RecordBuilder for NewsletterObject instances.
   */
  public static class Builder extends org.apache.avro.specific.SpecificRecordBuilderBase<NewsletterObject>
    implements org.apache.avro.data.RecordBuilder<NewsletterObject> {

    private java.lang.CharSequence title;
    private java.lang.CharSequence description;
    private java.lang.CharSequence publishedBy;
    private java.lang.CharSequence category;

    /** Creates a new Builder */
    private Builder() {
      super(SCHEMA$);
    }

    /**
     * Creates a Builder by copying an existing Builder.
     * @param other The existing Builder to copy.
     */
    private Builder(com.project.newsletter.dto.NewsletterObject.Builder other) {
      super(other);
      if (isValidValue(fields()[0], other.title)) {
        this.title = data().deepCopy(fields()[0].schema(), other.title);
        fieldSetFlags()[0] = true;
      }
      if (isValidValue(fields()[1], other.description)) {
        this.description = data().deepCopy(fields()[1].schema(), other.description);
        fieldSetFlags()[1] = true;
      }
      if (isValidValue(fields()[2], other.publishedBy)) {
        this.publishedBy = data().deepCopy(fields()[2].schema(), other.publishedBy);
        fieldSetFlags()[2] = true;
      }
      if (isValidValue(fields()[3], other.category)) {
        this.category = data().deepCopy(fields()[3].schema(), other.category);
        fieldSetFlags()[3] = true;
      }
    }

    /**
     * Creates a Builder by copying an existing NewsletterObject instance
     * @param other The existing instance to copy.
     */
    private Builder(com.project.newsletter.dto.NewsletterObject other) {
            super(SCHEMA$);
      if (isValidValue(fields()[0], other.title)) {
        this.title = data().deepCopy(fields()[0].schema(), other.title);
        fieldSetFlags()[0] = true;
      }
      if (isValidValue(fields()[1], other.description)) {
        this.description = data().deepCopy(fields()[1].schema(), other.description);
        fieldSetFlags()[1] = true;
      }
      if (isValidValue(fields()[2], other.publishedBy)) {
        this.publishedBy = data().deepCopy(fields()[2].schema(), other.publishedBy);
        fieldSetFlags()[2] = true;
      }
      if (isValidValue(fields()[3], other.category)) {
        this.category = data().deepCopy(fields()[3].schema(), other.category);
        fieldSetFlags()[3] = true;
      }
    }

    /**
      * Gets the value of the 'title' field.
      * @return The value.
      */
    public java.lang.CharSequence getTitle() {
      return title;
    }

    /**
      * Sets the value of the 'title' field.
      * @param value The value of 'title'.
      * @return This builder.
      */
    public com.project.newsletter.dto.NewsletterObject.Builder setTitle(java.lang.CharSequence value) {
      validate(fields()[0], value);
      this.title = value;
      fieldSetFlags()[0] = true;
      return this;
    }

    /**
      * Checks whether the 'title' field has been set.
      * @return True if the 'title' field has been set, false otherwise.
      */
    public boolean hasTitle() {
      return fieldSetFlags()[0];
    }


    /**
      * Clears the value of the 'title' field.
      * @return This builder.
      */
    public com.project.newsletter.dto.NewsletterObject.Builder clearTitle() {
      title = null;
      fieldSetFlags()[0] = false;
      return this;
    }

    /**
      * Gets the value of the 'description' field.
      * @return The value.
      */
    public java.lang.CharSequence getDescription() {
      return description;
    }

    /**
      * Sets the value of the 'description' field.
      * @param value The value of 'description'.
      * @return This builder.
      */
    public com.project.newsletter.dto.NewsletterObject.Builder setDescription(java.lang.CharSequence value) {
      validate(fields()[1], value);
      this.description = value;
      fieldSetFlags()[1] = true;
      return this;
    }

    /**
      * Checks whether the 'description' field has been set.
      * @return True if the 'description' field has been set, false otherwise.
      */
    public boolean hasDescription() {
      return fieldSetFlags()[1];
    }


    /**
      * Clears the value of the 'description' field.
      * @return This builder.
      */
    public com.project.newsletter.dto.NewsletterObject.Builder clearDescription() {
      description = null;
      fieldSetFlags()[1] = false;
      return this;
    }

    /**
      * Gets the value of the 'publishedBy' field.
      * @return The value.
      */
    public java.lang.CharSequence getPublishedBy() {
      return publishedBy;
    }

    /**
      * Sets the value of the 'publishedBy' field.
      * @param value The value of 'publishedBy'.
      * @return This builder.
      */
    public com.project.newsletter.dto.NewsletterObject.Builder setPublishedBy(java.lang.CharSequence value) {
      validate(fields()[2], value);
      this.publishedBy = value;
      fieldSetFlags()[2] = true;
      return this;
    }

    /**
      * Checks whether the 'publishedBy' field has been set.
      * @return True if the 'publishedBy' field has been set, false otherwise.
      */
    public boolean hasPublishedBy() {
      return fieldSetFlags()[2];
    }


    /**
      * Clears the value of the 'publishedBy' field.
      * @return This builder.
      */
    public com.project.newsletter.dto.NewsletterObject.Builder clearPublishedBy() {
      publishedBy = null;
      fieldSetFlags()[2] = false;
      return this;
    }

    /**
      * Gets the value of the 'category' field.
      * @return The value.
      */
    public java.lang.CharSequence getCategory() {
      return category;
    }

    /**
      * Sets the value of the 'category' field.
      * @param value The value of 'category'.
      * @return This builder.
      */
    public com.project.newsletter.dto.NewsletterObject.Builder setCategory(java.lang.CharSequence value) {
      validate(fields()[3], value);
      this.category = value;
      fieldSetFlags()[3] = true;
      return this;
    }

    /**
      * Checks whether the 'category' field has been set.
      * @return True if the 'category' field has been set, false otherwise.
      */
    public boolean hasCategory() {
      return fieldSetFlags()[3];
    }


    /**
      * Clears the value of the 'category' field.
      * @return This builder.
      */
    public com.project.newsletter.dto.NewsletterObject.Builder clearCategory() {
      category = null;
      fieldSetFlags()[3] = false;
      return this;
    }

    @Override
    @SuppressWarnings("unchecked")
    public NewsletterObject build() {
      try {
        NewsletterObject record = new NewsletterObject();
        record.title = fieldSetFlags()[0] ? this.title : (java.lang.CharSequence) defaultValue(fields()[0]);
        record.description = fieldSetFlags()[1] ? this.description : (java.lang.CharSequence) defaultValue(fields()[1]);
        record.publishedBy = fieldSetFlags()[2] ? this.publishedBy : (java.lang.CharSequence) defaultValue(fields()[2]);
        record.category = fieldSetFlags()[3] ? this.category : (java.lang.CharSequence) defaultValue(fields()[3]);
        return record;
      } catch (java.lang.Exception e) {
        throw new org.apache.avro.AvroRuntimeException(e);
      }
    }
  }

  @SuppressWarnings("unchecked")
  private static final org.apache.avro.io.DatumWriter<NewsletterObject>
    WRITER$ = (org.apache.avro.io.DatumWriter<NewsletterObject>)MODEL$.createDatumWriter(SCHEMA$);

  @Override public void writeExternal(java.io.ObjectOutput out)
    throws java.io.IOException {
    WRITER$.write(this, SpecificData.getEncoder(out));
  }

  @SuppressWarnings("unchecked")
  private static final org.apache.avro.io.DatumReader<NewsletterObject>
    READER$ = (org.apache.avro.io.DatumReader<NewsletterObject>)MODEL$.createDatumReader(SCHEMA$);

  @Override public void readExternal(java.io.ObjectInput in)
    throws java.io.IOException {
    READER$.read(this, SpecificData.getDecoder(in));
  }

}
