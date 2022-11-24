//package Models;
//
//import lombok.Getter;
//import lombok.Setter;
//
//import javax.persistence.*;
//import java.util.Set;
//
//@Entity
//@Setter
//@Getter
//@Table(name = "artists")
//public class Artists {
//
//    @Id
//    private Integer id;
//
//    @Column(nullable = false, length = 100)
//    private String name;
//
//    @Column(name= "email_address")
//    private String emailAddress;
//
//    @ManyToMany
//    @JoinTable(
//            name = "songs",
//            joinColumns = @JoinColumn(name = "student_id"),
//            inverseJoinColumns = @JoinColumn(name = "course_id")
//    )
//    Set<Songs> songs;
//
//
//
//}
