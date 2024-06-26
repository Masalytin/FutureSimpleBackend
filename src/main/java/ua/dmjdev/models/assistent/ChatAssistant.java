package ua.dmjdev.models.assistent;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.ai.chat.messages.AssistantMessage;
import org.springframework.ai.chat.messages.SystemMessage;
import org.springframework.ai.chat.messages.UserMessage;
import org.springframework.ai.openai.api.OpenAiApi.ChatCompletionMessage.Role;
import ua.dmjdev.dto.EnglishLevel;
import ua.dmjdev.models.usr.User;
import ua.dmjdev.util.PromptsUtil;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
public class ChatAssistant {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private Theme theme;
    @ManyToOne
    private User user;
    @OneToMany(cascade = CascadeType.ALL)
    private List<Message> messages;
    private LocalDateTime creationDateTime;

    public ChatAssistant(Theme theme, User user) {
        this.theme = theme;
        this.user = user;
        this.messages = new ArrayList<>();
        addNewMessage(Role.SYSTEM, String.format(PromptsUtil.CHAT_ASSISTANT_PROMPT_FORMAT, theme.getRole(), theme, EnglishLevel.BEGINNER));
        addNewMessage(Role.ASSISTANT, "Generate first message for start a dialog");
    }

    public void addNewMessage(Role role, String content) {
        this.messages.add(new Message(role, content));
    }

    public List<org.springframework.ai.chat.messages.Message> getSpringAIMessage() {
        List<org.springframework.ai.chat.messages.Message> result = new ArrayList<>();
        for (Message message : messages) {
            result.add(switch (message.getRole()) {
                case SYSTEM -> new SystemMessage(message.getContent());
                case USER -> new UserMessage(message.getContent());
                case ASSISTANT -> new AssistantMessage(message.getContent());
                case TOOL -> null;
            });
        }
        return result;
    }
}
