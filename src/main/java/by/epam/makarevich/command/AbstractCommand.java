package by.epam.makarevich.command;

import by.epam.makarevich.receiver.Receiver;
import by.epam.makarevich.request_content.RequestContent;
import by.epam.makarevich.util.Router;

public abstract class AbstractCommand {
    protected Receiver receiver;

    public AbstractCommand(Receiver receiver) {
        this.receiver = receiver;
    }

    public Receiver getReceiver() {
        return this.receiver;
    }

    public abstract Router execute(RequestContent requestContent);
}
