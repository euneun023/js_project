package entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name = "profile_info")
@NoArgsConstructor
public class Profile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long user_id;

    @Column(name = "name")
    private String name;

    @Column(name = "email")
    private String email;

    @Column(name = "password")
    private String password;

    @Column(name = "profile_img")
    private String profile_img;

    @Column(name = "job")
    private String job;

    @Column(name = "city_and_state")
    private String city_and_state;

    @Column(name = "self_introduce")
    private String self_introduce;

    @Column(name = "twitter_link")
    private String twitter_link;

    @Column(name = "facebook_link")
    private String facebook_link;
    @Column(name = "youtube_link")
    private String youtube_link;
    @Column(name = "linkedin_link")
    private String linkedin_link;
    @Column(name = "instagram_link")
    private String instagram_link;
    @Column(name = "enabled")
    private boolean enabled;
}
