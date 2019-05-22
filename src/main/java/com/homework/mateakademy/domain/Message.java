package com.homework.mateakademy.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@RequiredArgsConstructor
@Setter
@Getter
@NoArgsConstructor
public class Message {
@Id
@GeneratedValue(strategy= GenerationType.AUTO)
private Integer id;
private String text;
private String tag;
private User author;
}
