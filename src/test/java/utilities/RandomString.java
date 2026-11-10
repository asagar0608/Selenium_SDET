package utilities;


import java.util.UUID;

public class RandomString {

    public String randomstring() {

        return UUID.randomUUID()
                .toString()
                .replace("-", "")
                .substring(0, 6);

    }
}
