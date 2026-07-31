# Use Cases

## UC-01 View All Countries

Actor:

- User

Preconditions:

- Application is running.
- Database connection is available.

Main Flow:

1. User selects "All Countries by Population".
2. System retrieves countries from the database.
3. System sorts countries by population.
4. System displays the report.

Alternative Flow:

- Database connection fails.
- System displays an error message.

Postconditions:

- Population report is displayed.
