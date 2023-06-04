package biz.spring.core.model.dnk;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;

@Entity
@Table(name = "student")
public class Student{

    @Id
    @Column(name = "student_id", nullable = false)
    private Integer studentId;

    @Column(name = "student_class", nullable = false)
    @NotNull(message = "Поле \"Класс ученика\" не может быть пустым")
    @Size(max = 5, message = "Поле \"Класс ученика\" не может иметь более {max} символов")
    private String studentClass;

    @Column(name = "student_mun", nullable = false)
    @NotNull(message = "Поле \"Муниципалитет\" не может быть пустым")
    @Size(max = 250, message = "Поле \"Муниципалитет\" не может иметь более {max} символов")
    private String studentMun;

    @Column(name = "contract_id", nullable = false)
    @NotNull(message = "Поле \"Договор\" не может быть пустым")
    private Integer contractId;

    public Student(Integer studentId,
                   String studentClass,
                   String studentMun,
                   Integer contractId) {
        this.studentId = studentId;
        this.studentClass = studentClass;
        this.studentMun = studentMun;
        this.contractId = contractId;
    }

    public Student() {
    }

    public Integer getStudentId() {
        return studentId;
    }

    public void setStudentId(Integer studentId) {
        this.studentId = studentId;
    }

    public String getStudentClass() {
        return studentClass;
    }

    public void setStudentClass(String studentClass) {
        this.studentClass = studentClass;
    }

    public String getStudentMun() {
        return studentMun;
    }

    public void setStudentMun(String studentMun) {
        this.studentMun = studentMun;
    }

    public Integer getContractId() {
        return contractId;
    }

    public void setContractId(Integer contractId) {
        this.contractId = contractId;
    }
}
