package com.edwincodex.twitter.timeline.models;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table(name = "portfolio")
@ToString
public class Portfolio {

    @Id
    @GeneratedValue
//    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Getter @Setter @Column(name = "idportfolio")
    private Long idPortfolio;
    @Getter @Setter @Column(name = "description")
    private String description;
    @Getter @Setter @Column(name = "experience_summary")
    private String experience_summary;
    @Getter @Setter @Column(name = "id")
    private Long id;
    @Getter @Setter @Column(name = "image_url")
    private String imageUrl;
    @Getter @Setter @Column(name = "last_names")
    private String lastNames;
    @Getter @Setter @Column(name = "names")
    private String names;
    @Getter @Setter @Column(name = "tittle")
    private String tittle;
    @Getter @Setter @Column(name = "twitter_user_id")
    private String twitterUserId;
    @Getter @Setter @Column(name = "twitter_user_name")
    private String twitterUserName;
    @Getter @Setter @Column(name = "user_id")
    private String userId;
    @Getter @Setter @Column(name = "address")
    private String address;
    @Getter @Setter @Column(name = "email")
    private String email;
    @Getter @Setter @Column(name = "experience")
    private String experience;
    @Getter @Setter @Column(name = "image_path")
    private String imagePath;
    @Getter @Setter @Column(name = "name")
    private String name;
    @Getter @Setter @Column(name = "phone")
    private String phone;
    @Getter @Setter @Column(name = "twitter_user")
    private String twitterUser;
    @Getter @Setter @Column(name = "zip_code")
    private String zipCode;
    @Getter @Setter @Column(name = "title")
    private String title;

}
