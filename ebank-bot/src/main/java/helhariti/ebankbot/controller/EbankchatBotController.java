package helhariti.ebankbot.controller;

import helhariti.ebankbot.agent.EbankAiAgent;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class EbankchatBotController {
    private final EbankAiAgent ebankAiAgent;

    @GetMapping("/chat")
    public String chat(@RequestParam String query,
                       @RequestParam(defaultValue = "default") String conversationId) {
        return ebankAiAgent.chat(conversationId, query);
    }
}
