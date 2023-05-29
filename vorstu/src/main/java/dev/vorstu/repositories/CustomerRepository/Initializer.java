package dev.vorstu.repositories.CustomerRepository;

import dev.vorstu.entity.Password;
import dev.vorstu.entity.Role;
import dev.vorstu.entity.Student;
import dev.vorstu.entity.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class Initializer {
    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private UserRepository userRepository;
    public void initial() {
        studentRepository.save(new Student("Белов Алексей Данилович",           "def_group1", "Кристафоренко Юрий Алексеевич", "+791", "+111"));
        studentRepository.save(new Student("Филиппов Севастьян Агафонович",     "def_group2", "Кристафоренко Юрий Алексеевич", "+792", "+112"));
        studentRepository.save(new Student("Савина Дэнна Антоновна",            "def_group3", "Кристафоренко Юрий Алексеевич", "+793", "+113"));
        studentRepository.save(new Student("Терентьев Исаак Адольфович",        "def_group4", "Кристафоренко Юрий Алексеевич", "+794", "+114"));
        studentRepository.save(new Student("Авдеева Юнона Мэлсовна",            "def_group5", "Кристафоренко Юрий Алексеевич", "+795", "+115"));
        studentRepository.save(new Student("Морозов Самуил Митрофанович",       "def_group6", "Кристафоренко Юрий Алексеевич", "+796", "+116"));
        studentRepository.save(new Student("Мамонтов Святослав Серапионович",   "def_group7", "Кристафоренко Юрий Алексеевич", "+797", "+117"));
        studentRepository.save(new Student("Морозов Ираклий Петрович",          "def_group8", "Кристафоренко Юрий Алексеевич", "+798", "+118"));
        studentRepository.save(new Student("Красильников Назарий Николаевич",   "def_group9", "Кристафоренко Юрий Алексеевич", "+799", "+119"));
        studentRepository.save(new Student("Гусева Пелагея Романовна",          "def_group10", "Кристафоренко Юрий Алексеевич", "+800", "+120"));
        studentRepository.save(new Student("Белов Вадим Валентинович",          "def_group11", "Кристафоренко Юрий Алексеевич", "+801", "+121"));
        studentRepository.save(new Student("Попова Зара Серапионовна",          "def_group12", "Кристафоренко Юрий Алексеевич", "+802", "+122"));

        userRepository.save( new User (null,"student",  Role.STUDENT,2L, new Password("1234"),true));
        userRepository.save( new User (null,"admin",    Role.ADMIN,null, new Password("1234"),true));

//        String encoding = Base64.getEncoder().encodeToString((student.getUsername() + ":" + student.getPassword()).getBytes());
//        log.info(encoding);
    }
    public Student SaveStudent(Student student) {
        return studentRepository.save(student);
    }
}
