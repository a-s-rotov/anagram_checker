# Anagram Checker
## Description

An anagram is a word or phrase formed by rearranging the letters of a different word or phrase, typically using all the original letters exactly once. 
For example, the word anagram itself can be rearranged into nag a ram, as well as the word binary into brainy and the word adobe into abode.

## How to run

Commands for launch :

`docker-compose up`

or

`mvn spring-boot:run`

## Endpoint

To check two words, you need to call a endpoint:

`POST localhost:8080/check`

_POST request selected due to GET request length restrictions_

with body:

`{
"firstWord": "eae",
"secondWord": "eea"
}`



