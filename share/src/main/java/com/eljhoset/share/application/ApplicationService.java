package com.eljhoset.share.application;

public interface ApplicationService<C extends Command> {

    void execute(C c);
}
