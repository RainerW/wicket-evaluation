package com.example.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Index;

@Entity
public class Player implements Serializable
{
  @Id
  @GeneratedValue
  Long id;

  @Column(nullable = true)
  String vorname;

  @Column
  String nachname;

  @Column(nullable = false, unique = true)
  String email;

  @Enumerated
  SportArt sportart;

  public Player()
  {

  }

  public Player(SportArt art)
  {
    sportart = art;
  }

  public Long getId()
  {
    return id;
  }

  public void setId(Long id)
  {
    this.id = id;
  }

  public String getVorname()
  {
    return vorname;
  }

  public void setVorname(String vorname)
  {
    this.vorname = vorname;
  }

  public String getNachname()
  {
    return nachname;
  }

  public void setNachname(String nachname)
  {
    this.nachname = nachname;
  }

  public String getEmail()
  {
    return email;
  }

  public void setEmail(String email)
  {
    this.email = email;
  }

  public SportArt getSportart()
  {
    return sportart;
  }

  public void setSportart(SportArt sportart)
  {
    this.sportart = sportart;
  }

}
