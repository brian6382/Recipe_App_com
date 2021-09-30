FoodApp is simple App which uses [www.themealdb.com](https://www.themealdb.com/api/json/v1/1/) to get top headlines for country you live in or you can search for a specific news.
Focus of this app is to demonstrate (Not necessarily the best practices)

- MVVM Architecture with Java Flow and LiveData
- Android View Binding

# Screenshots

![Screenshot1](https://user-images.githubusercontent.com/82508349/135426766-9b75d4bb-8b8b-44a8-afe2-94a8ad84bead.jpg)   ![Screenshot1](https://user-images.githubusercontent.com/82508349/135426766-9b75d4bb-8b8b-44a8-afe2-94a8ad84bead.jpg)


# Setup
You will require Android Studio 3.0 (or newer).

- Git Clone the repo
- ### Get the API Key from [www.themealdb.com](https://www.themealdb.com/api/json/v1/1/)
- Find the file named `HomeDataSource` and replace `YOUR_API_KEY` with your api key
- Build app and enjoy :)

# Architecture

<img alt="FooApp Home" height="450px" src="https://raw.githubusercontent.com/brian6382/NewsApp/master/screenshot/architecture.png" />



# Libraries and Services Used

### Libraries
- Retrofit
- Glide
- Java Coroutines/Flow
- ViewModel and LiveData
- Android View Binding

### Services
- [themealdbApi](https://www.themealdb.com/api/json/v1/1/)

