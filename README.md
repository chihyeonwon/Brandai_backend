## 백엔드 Repository ##

📦main
┣ 📂generated
┣ 📂java
┃ ┣ 📂likelion
┃ ┃ ┣ 📂hackathon
┃ ┃ ┃ ┣ 📂BradingHelper
┃ ┃ ┃ ┃ ┣ 📂ApiAccess
┃ ┃ ┃ ┃ ┃ ┣ 📂ChatGpt
┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜ChatGptApiRequester.java
┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜ChatGptDataGenerator.java
┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜ChatGptPreprocessor.java
┃ ┃ ┃ ┃ ┃ ┣ 📂Controller
┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜DescriptionController.java
┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜LogoApiController.java
┃ ┃ ┃ ┃ ┃ ┣ 📂Description
┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜DescriptionPreprocessor.java
┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜DescriptionResponse.java
┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜DescriptionTemplate.java
┃ ┃ ┃ ┃ ┃ ┣ 📂Interfaces
┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜ApiRequesterInterface.java
┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜DataPreprocessorInterface.java
┃ ┃ ┃ ┃ ┃ ┣ 📂Logo
┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜LogoApiRequester.java
┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜LogoDataPreprocessor.java
┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜LogoGenerator.java
┃ ┃ ┃ ┃ ┃ ┣ 📂Papago
┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜PapagoApiRequester.java
┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜PapagoDataPreprocessor.java
┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜PapagoTranslator.java
┃ ┃ ┃ ┃ ┃ ┣ 📂Prompt
┃ ┃ ┃ ┃ ┃ ┃ ┣ 📂Description
┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜DescriptionPromptFoam.txt
┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜DescriptionPromptPreprocessor.java
┃ ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜DescriptionToStringPrompt.java
┃ ┃ ┃ ┃ ┃ ┃ ┣ 📂Interface
┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜PromptPreprocessor.java
┃ ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜ToStringPrompt.java
┃ ┃ ┃ ┃ ┃ ┃ ┣ 📂Logo
┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜LogoPromptFoam.txt
┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜LogoPromptPreprocessor.java
┃ ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜LogoToStringPrompt.java
┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜Prompt.java
┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜TranslatePrompt.java
┃ ┃ ┃ ┃ ┃ ┣ 📂Security
┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜TokenManager.java
┃ ┃ ┃ ┃ ┃ ┗ 📂Utils
┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜HttpUtils.java
┃ ┃ ┃ ┃ ┣ 📂Auth
┃ ┃ ┃ ┃ ┃ ┣ 📂Controller
┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜AuthController.java
┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜KakaoController.java
┃ ┃ ┃ ┃ ┃ ┣ 📂Service
┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜KakaoService.java
┃ ┃ ┃ ┃ ┃ ┗ 📜.DS_Store
┃ ┃ ┃ ┃ ┣ 📂Config
┃ ┃ ┃ ┃ ┃ ┣ 📜SecurityConfig.java
┃ ┃ ┃ ┃ ┃ ┗ 📜SwaggerConfig.java
┃ ┃ ┃ ┃ ┣ 📂DataCollection
┃ ┃ ┃ ┃ ┃ ┣ 📂Controller
┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜CardController.java
┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜UserAccountController.java
┃ ┃ ┃ ┃ ┃ ┣ 📂Dao
┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜CardDao.java
┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜UserAccountDao.java
┃ ┃ ┃ ┃ ┃ ┣ 📂Dto
┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜CardDto.java
┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜DescriptionDto.java
┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜UserAccountDto.java
┃ ┃ ┃ ┃ ┃ ┣ 📂Entity
┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜Card.java
┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜Description.java
┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜UserAccount.java
┃ ┃ ┃ ┃ ┃ ┣ 📂Repository
┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜CardRepository.java
┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜UserAccountRepository.java
┃ ┃ ┃ ┃ ┃ ┗ 📂Service
┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜CardService.java
┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜UserAccountService.java
┃ ┃ ┃ ┃ ┣ 📜.DS_Store
┃ ┃ ┃ ┃ ┗ 📜BrandingHelperApplication.java
┃ ┃ ┃ ┗ 📜.DS_Store
┃ ┃ ┗ 📜.DS_Store
┃ ┗ 📜.DS_Store
┣ 📂resources
┃ ┣ 📂static
┃ ┃ ┗ 📜index.html
┃ ┣ 📂templates
┃ ┗ 📜application.yml