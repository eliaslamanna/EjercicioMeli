package app.requirements;

import app.exceptions.MessageIncompleteException;

public abstract class HandlerRequirement <X, Y> {

    public Y ejecutar(X request) throws MessageIncompleteException {
        return run(request);
    }

    protected abstract Y run(X request) throws MessageIncompleteException;

}
