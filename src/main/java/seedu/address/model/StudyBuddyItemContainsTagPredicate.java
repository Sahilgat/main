package seedu.address.model;

import java.util.Set;
import java.util.function.Predicate;

import seedu.address.model.tag.Tag;

/**
 * Tests that a {@code StudyBuddyItem}'s {@code Tag} matches any of the tags given.
 */
public class StudyBuddyItemContainsTagPredicate implements Predicate<StudyBuddyItem> {
    private final Set<Tag> tags;

    public StudyBuddyItemContainsTagPredicate (Set<Tag> tags) {
        this.tags = tags;
    }

    // test on the person to see if he has the tag
    @Override
    public boolean test(StudyBuddyItem studyBuddyItem) {
        boolean boo;
        if (tags.isEmpty()) {
            boo = false;
        } else {
            boo = tags.stream()
                    .allMatch(studyBuddyItem::containsTag);
        }
        return boo;
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof StudyBuddyItemContainsTagPredicate // instanceof handles nulls
                && tags.equals(((StudyBuddyItemContainsTagPredicate) other).tags)); // state check
    }

}
