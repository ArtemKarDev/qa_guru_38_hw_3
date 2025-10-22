package TestData;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RegistrationData {
    private String firstName;
    private String lastName;
    private String email;
    private String gender;
    private String phoneNumber;
    private DateOfBirth dateOfBirth;
    private List<String> subjects;
    private List<String> hobbies;
    private String picture;
    private String address;
    private String state;
    private String city;

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    public static class DateOfBirth {
        private String day;
        private String month;
        private String year;
    }
}