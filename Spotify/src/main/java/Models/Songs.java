//package Models;
//
//import lombok.Getter;
//import lombok.Setter;
//
//import javax.persistence.*;
//import java.util.Set;
//
//@Getter
//@Setter
//@Entity
//@Table(name = "songs")
//public class Songs {
//
//    @Id
//    @GeneratedValue
//    private Integer id;
//
//
//    @Column(name="type", nullable = false)
//    private MUSICTYPE musictype;
//
//    @ManyToMany(mappedBy = "songs")
//    Set<Artists> artists;
//}
