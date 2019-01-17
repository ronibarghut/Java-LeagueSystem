package utils;

/**
 * Created by Antonio Zaitoun on 05/05/2018.
 */
@FunctionalInterface
public interface Command {
    void execute(FileAppender appender,String... args) throws Exception;
}