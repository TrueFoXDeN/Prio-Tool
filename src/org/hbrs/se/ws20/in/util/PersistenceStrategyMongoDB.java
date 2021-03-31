package org.hbrs.se.ws20.in.util;

import org.hbrs.se.ws20.al.exception.PersistenceException;

import java.util.List;

public class PersistenceStrategyMongoDB<Member> implements PersistenceStrategy<Member> {
    @Override
    public void openConnection() throws PersistenceException {
        throw new UnsupportedOperationException("Not implemented!");
    }

    @Override
    public void closeConnection() throws PersistenceException {
        throw new UnsupportedOperationException("Not implemented!");
    }

    @Override
    public void save(List<Member> member, String file) {
        throw new UnsupportedOperationException("Not implemented!");

    }

    @Override
    public List<Member> load(String file) {
        throw new UnsupportedOperationException("Not implemented!");
    }
}
