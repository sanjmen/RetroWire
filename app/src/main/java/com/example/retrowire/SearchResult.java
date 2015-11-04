// Code generated by Wire protocol buffer compiler, do not edit.
// Source file: SearchResult.proto at 7:1
package com.example.retrowire;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;

import java.io.IOException;

import okio.ByteString;

import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.lang.StringBuilder;

public final class SearchResult extends Message<SearchResult, SearchResult.Builder> {
    public static final ProtoAdapter<SearchResult> ADAPTER = new ProtoAdapter<SearchResult>(FieldEncoding.LENGTH_DELIMITED, SearchResult.class) {
        @Override
        public int encodedSize(SearchResult value) {
            return ProtoAdapter.STRING.encodedSizeWithTag(1, value.query)
                    + value.unknownFields().size();
        }

        @Override
        public void encode(ProtoWriter writer, SearchResult value) throws IOException {
            ProtoAdapter.STRING.encodeWithTag(writer, 1, value.query);
            writer.writeBytes(value.unknownFields());
        }

        @Override
        public SearchResult decode(ProtoReader reader) throws IOException {
            Builder builder = new Builder();
            long token = reader.beginMessage();
            for (int tag; (tag = reader.nextTag()) != -1;) {
                switch (tag) {
                    case 1: builder.query(ProtoAdapter.STRING.decode(reader)); break;
                    default: {
                        FieldEncoding fieldEncoding = reader.peekFieldEncoding();
                        Object value = fieldEncoding.rawProtoAdapter().decode(reader);
                        builder.addUnknownField(tag, fieldEncoding, value);
                    }
                }
            }
            reader.endMessage(token);
            return builder.build();
        }

        @Override
        public SearchResult redact(SearchResult value) {
            Builder builder = value.newBuilder();
            builder.clearUnknownFields();
            return builder.build();
        }
    };

    private static final long serialVersionUID = 0L;

    public static final String DEFAULT_QUERY = "";

    public final String query;

    public SearchResult(String query) {
        this(query, ByteString.EMPTY);
    }

    public SearchResult(String query, ByteString unknownFields) {
        super(unknownFields);
        this.query = query;
    }

    @Override
    public Builder newBuilder() {
        Builder builder = new Builder();
        builder.query = query;
        builder.addUnknownFields(unknownFields());
        return builder;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) return true;
        if (!(other instanceof SearchResult)) return false;
        SearchResult o = (SearchResult) other;
        return equals(unknownFields(), o.unknownFields())
                && equals(query, o.query);
    }

    @Override
    public int hashCode() {
        int result = super.hashCode;
        if (result == 0) {
            result = unknownFields().hashCode();
            result = result * 37 + (query != null ? query.hashCode() : 0);
            super.hashCode = result;
        }
        return result;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        if (query != null) builder.append(", query=").append(query);
        return builder.replace(0, 2, "SearchResult{").append('}').toString();
    }

    public static final class Builder extends com.squareup.wire.Message.Builder<SearchResult, Builder> {
        public String query;

        public Builder() {
        }

        public Builder query(String query) {
            this.query = query;
            return this;
        }

        @Override
        public SearchResult build() {
            if (query == null) {
                throw missingRequiredFields(query, "query");
            }
            return new SearchResult(query, buildUnknownFields());
        }
    }
}
