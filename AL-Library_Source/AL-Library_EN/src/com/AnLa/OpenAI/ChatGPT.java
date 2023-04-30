package com.AnLa.OpenAI;
// Make By Bình An || AnLaVN || KatoVN

import com.theokanning.openai.service.OpenAiService;
import com.theokanning.openai.completion.CompletionRequest;

/**The ChatGPT class supports to connect to OpenAI using API key.
 * @author AnLaVN
 */
public class ChatGPT {
    private OpenAiService service = null;
    private ChatGPT(){}
    
    /**Create an ChatGPT service using API key. API key is a mandatory requirement. It has format "sk-XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX".<br>
     * Login to OpenAI website with your account and access to https://beta.openai.com/account/api-keys to get API key.<br>
     * @param APIKey is your API key in OpenAI.
     */
    public ChatGPT(String APIKey){
        service = new OpenAiService(APIKey);
    }
    
    /**Our GPT-3 models can understand and generate natural language. 
     * We offer four main models with different levels of power suitable for different tasks. 
     * Davinci is the most capable model, and Ada is the fastest.
     */
    public static enum Model{
        /**Most capable GPT-3 model. 
         * Can do any task the other models can do, often with higher quality, 
         * longer output and better instruction-following. 
         * Also supports inserting completions within text.<br>
         * MAX REQUEST: 4,000 tokens.<br>
         * PRICING: $0.0200 / 1K tokens.<br>
         * TRAINING DATA: Up to Jun 2021.
         */
        Davinci,
        
        /**Very capable, but faster and lower cost than Davinci.<br>
         * MAX REQUEST: 2,048 tokens.<br>
         * PRICING: $0.0020 / 1K tokens.<br>
         * TRAINING DATA: Up to Oct 2019.
         */
        Curie, 
        
        /**Capable of straightforward tasks, very fast, and lower cost.<br>
         * MAX REQUEST: 2,048 tokens.<br>
         * PRICING: $0.0005 / 1K tokens<br>
         * TRAINING DATA: Up to Oct 2019.
         */
        Babbage,
        
        /**Capable of very simple tasks, usually the fastest model in the GPT-3 series, and lowest cost.<br>
         * MAX REQUEST: 2,048 tokens.<br>
         * PRICING: $0.0004 / 1K tokens<br>
         * TRAINING DATA: Up to Oct 2019.
         */
        Ada
    }
    
    
    /**Use this method to chat with ChatGPT bot, just ask the question
     * and you will get reply from chatGPT bot.<br>Using model Davinci with max 256 token.
     * @param question a string of any question you wonder. The longer the question, the more tokens it costs.<br>
     * @return a string choices of model with your question.
     * @see ChatGPT#Chat(java.lang.String, com.AnLa.OpenAI.ChatGPT.Model, int) 
     */
    public final String Chat(String question){
        return Chat(question, Model.Davinci, 256);
    }
    
    
    /**Use this method to chat with ChatGPT bot, just ask the question,
     * enter the max token will return
     * and you will get reply from chatGPT bot.<br>Using model Davinci.
     * @param question a string of any question you wonder. The longer the question, the more tokens it costs.<br>
     * @param maxTokens is the maximum token limit will return. Other models only have 2048 while Davinci is 4000.<br>
     * @return a string choices of model with your question.
     * @see ChatGPT#Chat(java.lang.String, com.AnLa.OpenAI.ChatGPT.Model, int) 
     */
    public final String Chat(String question, int maxTokens){
        return Chat(question, Model.Davinci, maxTokens);
    }

    
    /**Use this method to chat with ChatGPT bot, just ask the question,
     * required the model will answer you
     * and you will get reply from chatGPT bot.<br>Using max 256 token.
     * @param question a string of any question you wonder. The longer the question, the more tokens it costs.<br>
     * @param model is a model will answer your question. Ada is the fastest model, while Davinci is the most powerful.<br>
     * @return a string choices of model with your question.
     * @see ChatGPT#Chat(java.lang.String, com.AnLa.OpenAI.ChatGPT.Model, int) 
     */
    public final String Chat(String question, Model model){
        return Chat(question, model, 256);
    }

    
    /**Use this method to chat with ChatGPT bot, just ask the question,
     * required the model will answer you,
     * enter the max token will return
     * and you will get reply from chatGPT bot.
     * @param question a string of any question you wonder. The longer the question, the more tokens it costs.<br>
     * @param model is a model will answer your question. Ada is the fastest model, while Davinci is the most powerful.<br>
     * @param maxTokens is the maximum token limit will return. Other models only have 2048 while Davinci is 4000.<br>
     * @return a string that the model choices to answer your question.
     */
    public final String Chat(String question, Model model, int maxTokens){
        CompletionRequest completionRequest = CompletionRequest.builder()
                .prompt(question)
                .model(model == Model.Davinci ? "text-davinci-003" : "text-" + model.toString().toLowerCase() + "-001")
                .maxTokens(model == Model.Davinci ? (maxTokens > 4000 ? 4000 : maxTokens) : (maxTokens > 2048 ? 2048 : maxTokens))
                .echo(true)
                .build();
        return service.createCompletion(completionRequest).getChoices().get(0).getText().trim();
    }
}