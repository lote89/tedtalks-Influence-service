# Simple TED Talks Influence API

This is a minimal Spring Boot application created for the iO Java Assessment.

## Features

- Import a CSV containing TED Talk data (title, author, date, views, likes, link)
- Store talks in an in-memory H2 database
- Provide a simple influence score:
  score = views * 0.7 + likes * 0.3

- Three endpoints:

| Method | Endpoint         | Description               |
|--------|------------------|---------------------------|
| POST   | /api/import      | Import CSV file           |
| GET    | /api/talks       | List all TED Talks        |
| GET    | /api/influence   | Speaker influence ranking |

## Assumptions
- CSV headers match the provided dataset
- Date may be empty or not parseable
- Views/likes cleaned of commas and non-numeric characters
- Focus is on simplicity due to the 4-hour guideline

## Run 
If you want to run it locally:
mvn spring-boot:run

## Why this design?

- **Simplicity:** Minimal code to fit timebox  
- **Records:** Clean DTOs  
- **H2 DB:** No setup required  
- **Simple influence formula:** Easy to explain  
