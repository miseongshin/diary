package com.today10sec.diary.customize.validator;

import javax.validation.GroupSequence;
import javax.validation.groups.Default;

@GroupSequence(value = {Sequences.Order1.class, Sequences.Order2.class, Sequences.Order3.class, Sequences.Order4.class, Sequences.Order5.class, Sequences.Order6.class, Sequences.Order7.class, Sequences.Order8.class, Sequences.Order9.class, Sequences.Order10.class, Default.class})
public interface Sequences {

    public @interface Order1 {
    }

    public @interface Order2 {
    }

    public @interface Order3 {
    }

    public @interface Order4 {
    }

    public @interface Order5 {
    }

    public @interface Order6 {
    }

    public @interface Order7 {
    }

    public @interface Order8 {
    }

    public @interface Order9 {
    }

    public @interface Order10 {
    }
}
