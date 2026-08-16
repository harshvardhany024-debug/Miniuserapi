package in.codeneeti.Miniuserapi.service;

import in.codeneeti.Miniuserapi.entity.User;
import org.hibernate.id.IntegralDataTypeHolder;
import org.hibernate.sql.Update;
import org.springframework.stereotype.Service;
import in.codeneeti.Miniuserapi.repository.Userrepo;
import org.w3c.dom.stylesheets.LinkStyle;

import java.util.List;
import java.util.Optional;

@Service
public class Userservice {
    private final Userrepo  userrepo;

    public Userservice (Userrepo userrepo){
        this.userrepo=userrepo;
    }

    // calling predefined methode


    public User creatUser(User user){
        return userrepo.save(user);

    }
    // methode which is giving all user info
    public List<User> Getalluser(){

        return userrepo.findAll();
    }
    public User Getbyid(Integer id){
        return userrepo.getReferenceById(id);

    }


    // delete methode
    public  void Deletebyid(Integer id) {
        Optional<User> user = userrepo.findById(id);
 userrepo.deleteById(id);
    }
    public User Updatebyid(Integer id ,User user){
        User existingu = userrepo.findById(id).orElseThrow();// finding User using id
        existingu.setAge(user.getAge()); // replacing the info of usr through  the given information
        existingu.setEmail(user.getEmail());
        existingu.setName(user.getName());
       // existingu.setId(user.getId());
        return  userrepo.save(existingu);

    }
// feature branch changes git
}
