# Rock-Paper-Scissors Game
Is simple spring boot web application

Change **rps.opponent.client** property in **application.properties** file to choose game opponent client.
Local client is used by default. Supports LOCAL and REMOTE property values

Use **GET {host}/game/rps/figures** to get supported game figures.

Use **POST {host}/game/rps/throw** with body **{"figure":"..."}** (where "figure" is supported figure) to play

**TODO:**
1. Implement REMOTE client to work with https://curbrockpaperscissors.docs.apiary.io
2. Add docker file
3. Extend game combinations
4. Add exception handling
