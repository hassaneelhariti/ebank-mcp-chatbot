package helhariti.ebankbot.agent;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.client.advisor.MessageChatMemoryAdvisor;
import org.springframework.ai.chat.memory.ChatMemory;
import org.springframework.ai.tool.ToolCallbackProvider;
import org.springframework.stereotype.Service;

@Service
public class EbankAiAgent {

    private final ChatClient chatClient;
    private static final String SYSTEM_PROMPT = """
    Vous êtes un assistant qui répond aux questions de l'utilisateur à propos
    des clients et des comptes bancaires.
    Règles :
    - Pour obtenir une donnée (nombre de clients, détail d'un client, comptes...),
    utilisez toujours les outils disponibles. Ne devinez jamais.
    - Pour un simple comptage, utilisez l'outil de comptage plutôt que de lister tous les clients.
   - Ne créez un client que si l'utilisateur le demande explicitement.
   Ne fournissez jamais d'identifiant : il est généré automatiquement.
   - Si les outils ne renvoient aucune information utile, répondez : JE NE SAIS PAS.
   - Si un outil renvoie une erreur, expliquez-le simplement à l'utilisateur. """;

    public EbankAiAgent(ChatClient.Builder chatClient, ChatMemory chatMemory, ToolCallbackProvider toolCallbackProvider) {
        this.chatClient = chatClient
                .defaultSystem(SYSTEM_PROMPT)
                .defaultAdvisors(MessageChatMemoryAdvisor.builder(chatMemory).build())
                .defaultTools(toolCallbackProvider)
                .build();
    }

    public String chat(String conversationId, String query) {
        return chatClient.prompt()
                .user(query)
                .advisors(a -> a.param(ChatMemory.CONVERSATION_ID, conversationId))
                .call()
                .content();
    }
}