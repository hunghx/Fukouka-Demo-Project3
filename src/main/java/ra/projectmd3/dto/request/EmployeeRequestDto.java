package ra.projectmd3.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;
import ra.projectmd3.model.Employee;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class EmployeeRequestDto {
    private Employee employee;
    private MultipartFile file;
}
