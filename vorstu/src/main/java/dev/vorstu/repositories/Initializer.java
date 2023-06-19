package dev.vorstu.repositories;

import dev.vorstu.entity.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class Initializer {
    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private GroupRepository groupRepository;
    @Autowired
    private UserRepository userRepository;
    public void initial() {
        Group groupOne = new Group("group1", 12L, "Кристафоренко Юрий Алексеевич");
        Group groupTwo = new Group("group2", 0L, "Криренко Дед Алексеевич");

        groupRepository.save(groupOne);
        groupRepository.save(groupTwo);

        studentRepository.save(new Student(1L,"Белов Алексей Данилович",           groupOne, "+791", "+111"));
        studentRepository.save(new Student(2L,"Филиппов Севастьян Агафонович",     groupOne, "+792", "+112"));
        studentRepository.save(new Student(3L, "Савина Дэнна Антоновна",            groupOne, "+793", "+113"));
        studentRepository.save(new Student(4L, "Терентьев Исаак Адольфович",        groupOne, "+794", "+114"));
        studentRepository.save(new Student(5L, "Авдеева Юнона Мэлсовна",            groupOne, "+795", "+115"));
        studentRepository.save(new Student(6L, "Морозов Самуил Митрофанович",       groupOne, "+796", "+116"));
        studentRepository.save(new Student(7L, "Мамонтов Святослав Серапионович",   groupOne, "+797", "+117"));
        studentRepository.save(new Student(8L, "Морозов Ираклий Петрович",          groupOne, "+798", "+118"));
        studentRepository.save(new Student(9L, "Красильников Назарий Николаевич",   groupOne, "+799", "+119"));
        studentRepository.save(new Student(10L, "Гусева Пелагея Романовна",          groupOne, "+800", "+120"));
        studentRepository.save(new Student(11L, "Белов Вадим Валентинович",          groupOne, "+801", "+121"));
        studentRepository.save(new Student(12L, "Попова Зара Серапионовна",          groupOne, "+802", "+122"));

        userRepository.save( new User (null,"student",  Role.STUDENT,2L,    new Password("1234"),true));
        userRepository.save( new User (null,"admin",    Role.ADMIN,null,    new Password("1234"),true));
        userRepository.save( new User (null,"teacher",  Role.TEACHER,null,  new Password("1234"),true));


//        String encoding = Base64.getEncoder().encodeToString((student.getUsername() + ":" + student.getPassword()).getBytes());
//        log.info(encoding);
    }
    public Student SaveStudent(Student student) {
        return studentRepository.save(student);
    }
}
