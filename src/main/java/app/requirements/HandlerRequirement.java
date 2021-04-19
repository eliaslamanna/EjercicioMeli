package app.requirements;

import app.exceptions.DifferenteMessagesException;

public abstract class HandlerRequirement <X, Y> {

    public Y ejecutar(X request) throws DifferenteMessagesException {
        return run(request);
    }

    protected abstract Y run(X request) throws DifferenteMessagesException;

}
