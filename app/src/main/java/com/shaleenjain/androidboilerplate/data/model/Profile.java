package com.shaleenjain.androidboilerplate.data.model;

import android.os.Parcelable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.google.auto.value.AutoValue;
import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.squareup.sqldelight.ColumnAdapter;
import com.squareup.sqldelight.RowMapper;

import java.util.Date;

@AutoValue
public abstract class Profile implements ProfileModel, Parcelable {

    private static final ColumnAdapter<Name, String> NAME_ADAPTER = new ColumnAdapter<Name, String>() {
        @NonNull
        @Override
        public Name decode(String databaseValue) {
            int index = databaseValue.indexOf(':');
            return Name.create(databaseValue.substring(0, index),
                                    databaseValue.substring(index+1));
        }

        @Override
        public String encode(@NonNull Name value) {
            return value.first() + ":" + value.last();
        }
    };

    private static final ColumnAdapter<Date, Long> DATE_ADAPTER = new ColumnAdapter<Date, Long>() {
        @Override public Date decode(Long databaseValue) {
            return new Date(databaseValue);
        }

        @Override public Long encode(@NonNull Date value) {
            return value.getTime();
        }
    };

    @SuppressWarnings({"unchecked", "StaticInitializerReferencesSubClass"})
    public static final Factory<Profile> FACTORY = new Factory<>(AutoValue_Profile::new,
            NAME_ADAPTER, DATE_ADAPTER);

    public static final RowMapper<Profile> SELECT_ALL_MAPPER = FACTORY.selectALLMapper();

    public abstract String email();
    public abstract Name name();
    public abstract String hexColor();
    public abstract Date dateOfBirth();
    @Nullable public abstract String bio();
    @Nullable public abstract String avatar();

    public static Builder builder() {
        return new AutoValue_Profile.Builder();
    }

    public static TypeAdapter<Profile> typeAdapter(Gson gson) {
        return new AutoValue_Profile.GsonTypeAdapter(gson);
    }

    @AutoValue.Builder
    public abstract static class Builder {
        public abstract Builder setName(Name name);
        public abstract Builder setEmail(String email);
        public abstract Builder setHexColor(String hexColor);
        public abstract Builder setDateOfBirth(Date dateOfBirth);
        public abstract Builder setBio(String bio);
        public abstract Builder setAvatar(String avatar);
        public abstract Profile build();
    }
}
