package util;

public class IdGenerator {
    public static Integer getNextUserId(Integer lastUserId) {
        return lastUserId+1;
    }
}
