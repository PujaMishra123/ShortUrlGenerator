
#This project generates 7 digit short urls from long urls provided using base62 conversion

# Used singleton concurrent hashmap as data structure to store the mapping between the short and long urls which is consistent across all users

#Future Scope:
  #including redis to cache frequently used urls to reduce server calls
  #Use sharding by implementing a relational database in place of hashmap to distribute users with ranges of numbers for generating unique urls
  #Use separete tables to store used urls and unused urls to prevent duplicacy in short url generation
  