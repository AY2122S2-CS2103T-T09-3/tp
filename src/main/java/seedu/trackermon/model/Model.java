package seedu.trackermon.model;

import java.nio.file.Path;
import java.util.function.Predicate;

import javafx.collections.ObservableList;
import seedu.trackermon.commons.core.GuiSettings;
import seedu.trackermon.model.show.Show;

/**
 * The API of the Model component.
 */
public interface Model {
    /** {@code Predicate} that always evaluate to true */
    Predicate<Show> PREDICATE_SHOW_ALL_SHOWS = unused -> true;

    /**
     * Replaces user prefs data with the data in {@code userPrefs}.
     */
    void setUserPrefs(ReadOnlyUserPrefs userPrefs);

    /**
     * Returns the user prefs.
     */
    ReadOnlyUserPrefs getUserPrefs();

    /**
     * Returns the user prefs' GUI settings.
     */
    GuiSettings getGuiSettings();

    /**
     * Sets the user prefs' GUI settings.
     */
    void setGuiSettings(GuiSettings guiSettings);

    /**
     * Returns the user prefs' address book file path.
     */
    Path getShowListFilePath();

    /**
     * Sets the user prefs' address book file path.
     */
    void setShowListFilePath(Path addressBookFilePath);

    /**
     * Replaces address book data with the data in {@code addressBook}.
     */
    void setShowList(ReadOnlyShowList addressBook);

    /** Returns the ShowList */
    ReadOnlyShowList getShowList();

    /**
     * Returns true if a person with the same identity as {@code person} exists in the address book.
     */
    boolean hasShow(Show person);

    /**
     * Deletes the given person.
     * The person must exist in the address book.
     */
    void deleteShow(Show target);

    /**
     * Adds the given person.
     * {@code person} must not already exist in the address book.
     */
    void addShow(Show show);

    /**
     * Replaces the given person {@code target} with {@code editedShow}.
     * {@code target} must exist in the address book.
     * The person identity of {@code editedShow} must not be the same as another existing person in the address book.
     */
    void setShow(Show target, Show editedShow);

    /** Returns an unmodifiable view of the filtered person list */
    ObservableList<Show> getFilteredShowList();

    /**
     * Updates the filter of the filtered person list to filter by the given {@code predicate}.
     * @throws NullPointerException if {@code predicate} is null.
     */
    void updateFilteredShowList(Predicate<Show> predicate);
}