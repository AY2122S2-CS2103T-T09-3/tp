package seedu.trackermon.logic.commands;

import static java.util.Objects.requireNonNull;

import java.util.List;
import java.util.Random;

import seedu.trackermon.logic.commands.exceptions.CommandException;
import seedu.trackermon.model.Model;
import seedu.trackermon.model.show.Show;
import seedu.trackermon.model.show.SuggestPredicate;

public class SuggestCommand extends Command {

    public static final String COMMAND_WORD = "suggest";

    public static final String MESSAGE_SUCCESS = "Here is my suggestion";

    public static final String MESSAGE_FAILURE = "There are no shows currently being listed!";

    public static final String TAG_ERROR = "Tag parameter must only be a single word.\n"
            + "Example: " + COMMAND_WORD + " t/Action";

    public SuggestCommand() {
    }

    @Override
    public CommandResult execute(Model model) throws CommandException {
        requireNonNull(model);
        List<Show> currList = model.getFilteredShowList();
        Integer sizeOfShowList = currList.size();
        if (sizeOfShowList <= 0) {
            throw new CommandException(MESSAGE_FAILURE);
        }
        Show randomShow = getRandomShow(model);
        SuggestPredicate suggestPredicate = new SuggestPredicate(randomShow);
        model.updateFilteredShowList(suggestPredicate);
        return new CommandResult(MESSAGE_SUCCESS);
    }

    private static Show getRandomShow(Model model) {
        Random rn = new Random();
        List<Show> currList = model.getFilteredShowList();
        Integer sizeOfShowList = currList.size();
        Integer randomIndex = rn.nextInt(sizeOfShowList - 1);
        return currList.get(randomIndex);
    }
}
