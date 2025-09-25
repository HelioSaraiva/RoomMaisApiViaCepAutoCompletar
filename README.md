# ✅ App de Cadastro de Endereços via CEP (Kotlin + Compose)

Aplicativo Android desenvolvido em **Kotlin** utilizando **Jetpack Compose (Material 3)** que permite o preenchimento automático de endereço a partir do **CEP** consumindo a API [ViaCEP](https://viacep.com.br/).  
O projeto já possui integração com **Room Database** para persistência local dos cadastros de endereço.

---

## 📸 Preview do App

> Adicione aqui prints ou GIFs (ex: tela de cadastro e listagem de endereços)

---

## 📌 Funcionalidades

- [x] Tela de **Cadastro de Endereço**  
- [x] Busca automática de dados pelo **CEP** (API ViaCEP)  
- [x] Preenchimento automático dos campos: Rua, Bairro, Cidade, Estado  
- [x] Validação dos campos  
- [x] Botão de **Salvar no banco local (Room)**  
- [x] Arquitetura organizada no padrão **MVC**  
- [x] Uso de **Coroutines** para chamadas assíncronas sem travar a UI  
- [x] Persistência em **Room Database** para consultas futuras  

---

## 💡 Destaques Técnicos

- **Linguagem:** Kotlin  
- **UI:** Jetpack Compose Material 3  
- **Arquitetura:** MVC (Model-View-Controller)  
- **Network:** Retrofit + Gson + Coroutines  
- **Banco de Dados:** Room Database  
- **Controle de estado:** `mutableStateOf` e `rememberSaveable`  
- **Boas práticas:** Separação de camadas, código comentado, uso de `suspend fun` para IO  

---

## 🚀 Como executar

1. Clone o repositório:
```bash
git clone https://github.com/HelioSaraiva/RoomMaisApiViaCepAutoCompletar.git
```

2. Abra no **Android Studio (Arctic Fox ou superior)**

3. Sincronize as dependências (Gradle Sync)

4. Execute em um emulador ou dispositivo físico Android (SDK 24+)

---

## 📂 Estrutura do Projeto

```
├── data/
│   ├── model/Endereco.kt          # Entidade de endereço (Room + Compose)
│   ├── local/AppDatabase.kt       # Configuração do banco Room
│   ├── local/EnderecoDao.kt       # DAO para CRUD de endereços
│   ├── remote/ViaCepApi.kt        # Interface Retrofit (API ViaCEP)
│   └── remote/RetrofitClient.kt   # Configuração do Retrofit
│
├── ui/
│   ├── view/TelaCadastro.kt       # Tela Compose (View)
│   └── controller/EnderecoController.kt # Controller que orquestra a lógica
│
├── MainActivity.kt                 # Entry point chamando TelaCadastro
└── README.md                       # Documentação do projeto
```

---

## 👨‍💻 Para recrutadores

Este projeto demonstra que o desenvolvedor:

- Domina **Kotlin** para desenvolvimento Android moderno  
- Utiliza **Jetpack Compose Material 3** para interfaces declarativas  
- Conhece **Retrofit + Coroutines** para consumo de APIs assíncronas  
- Implementa persistência local com **Room Database**  
- Estrutura projetos seguindo **boas práticas de arquitetura (MVC)**  
- Sabe trabalhar com **estado reativo** em Compose  
- Entende a importância de **código limpo, comentado e modularizado**  

---

## 🛠️ Melhorias futuras

- [ ] Criar tela de **Listagem de Endereços salvos**  
- [ ] Implementar **edição e exclusão** de endereços  
- [ ] Validação mais avançada dos campos (Regex de CEP, etc.)  
- [ ] Integração com API de geolocalização para exibir o mapa  
- [ ] Exportar dados para **nuvem (Firebase)**  

---

## 📄 Licença

Este projeto está sob a licença MIT.  
Sinta-se livre para estudar, modificar e usar no seu portfólio!

---

## 🙋 Sobre o autor

Desenvolvido por **Helio Saraiva Buzato**  
📧 buzato@hotmail.com  
🔗 [LinkedIn](https://linkedin.com/in/heliosaraivabuzato)  
🔗 [GitHub](https://github.com/HelioSaraiva)  
