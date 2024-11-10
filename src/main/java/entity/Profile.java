package entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@Entity
@Getter
@Setter
public class Profile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long user_id;
    private Long career_id;
    private Long edu_id;
    private Long skill_id;
    private String name;
    private String email;
    private String password;
    private String profile_img;
    private String job;
    private String city_and_state;
    private String self_introduce;
    private String twitter_link;
    private String facebook_link;
    private String youtube_link;
    private String linkedin_link;
    private String instagram_link;
    private boolean enabled;
}
