package com.AnLa.OpenAI;
// Make By Bình An || AnLaVN || KatoVN

import com.theokanning.openai.service.OpenAiService;
import com.theokanning.openai.completion.CompletionRequest;

/**Lớp ChatGPT hỗ trợ kết nối với OpenAI bằng khoá API.
 * @author AnLaVN
 */
public class ChatGPT {
    private OpenAiService service = null;
    private ChatGPT(){}
    
    /**Tạo dịch vụ ChatGPT bằng khóa API. Khóa API là một yêu cầu bắt buộc. Nó có định dạng "sk-XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX".<br>
     * Đăng nhập vào trang web OpenAI bằng tài khoản của bạn và truy cập https://beta.openai.com/account/api-keys để lấy khóa API.<br>
     * @param APIKey là khóa API của bạn trong OpenAI.
     */
    public ChatGPT(String APIKey){
        service = new OpenAiService(APIKey);
    }
    
    /**Các mẫu GPT-3 của chúng tôi có thể hiểu và tạo ngôn ngữ tự nhiên.
     * Chúng tôi cung cấp bốn model chính với các mức công suất khác nhau phù hợp với các nhiệm vụ khác nhau.
     * Davinci là model có khả năng nhất và Ada là người nhanh nhất.
     */
    public static enum Model{
        /**Mô hình GPT-3 có khả năng nhất.
         * Có thể thực hiện bất kỳ nhiệm vụ nào mà các mô hình khác có thể thực hiện, thường với chất lượng cao hơn,
         * đầu ra dài hơn và làm theo hướng dẫn tốt hơn.
         * Cũng hỗ trợ chèn phần hoàn thành trong văn bản.<br>
         * YÊU CẦU TỐI ĐA: 4.000 token<br>
         * GIÁ: $0,0200 / 1K token.<br>
         * DỮ LIỆU ĐÀO TẠO: Đến tháng 6/2021.
         */
        Davinci,
        
        /**Rất hiệu quả, nhưng nhanh hơn và chi phí thấp hơn Davinci.<br>
         * YÊU CẦU TỐI ĐA: 2.048 token<br>
         * GIÁ: $0,0020 / 1K token.<br>
         * SỐ LIỆU ĐÀO TẠO: Đến tháng 10/2019.
         */
        Curie, 
        
        /**Có khả năng thực hiện các tác vụ đơn giản, rất nhanh và chi phí thấp hơn.<br>
         * YÊU CẦU TỐI ĐA: 2.048 token<br>
         * GIÁ: $0,0005 / 1K token<br>
         * SỐ LIỆU ĐÀO TẠO: Đến tháng 10/2019.
         */
        Babbage,
        
        /**Có khả năng thực hiện các tác vụ rất đơn giản, thường là kiểu máy nhanh nhất trong dòng GPT-3 và chi phí thấp nhất.<br>
         * YÊU CẦU TỐI ĐA: 2.048 token<br>
         * GIÁ: $0,0004 / 1K token<br>
         * SỐ LIỆU ĐÀO TẠO: Đến tháng 10/2019.
         */
        Ada
    }
    
    
    /**Sử dụng phương thức này để trò chuyện với bot ChatGPT, chỉ cần đặt câu hỏi
     * và bạn sẽ nhận được phản hồi từ bot chatGPT.<br>Sử dụng model Davinci với tối đa 256 token.
     * @param question một chuỗi câu hỏi bất kỳ mà bạn thắc mắc. Câu hỏi càng dài thì càng tốn nhiều token.<br>
     * @return một chuỗi mà model lựa chọn trả lời cho câu hỏi của bạn.
     * @see ChatGPT#Chat(java.lang.String, com.AnLa.OpenAI.ChatGPT.Model, int) 
     */
    public final String Chat(String question){
        return Chat(question, Model.Davinci, 256);
    }
    
    
    /**Sử dụng phương thức này để trò chuyện với bot ChatGPT, chỉ cần đặt câu hỏi,
     * nhập token tối đa sẽ trả lại
     * và bạn sẽ nhận được phản hồi từ bot chatGPT.<br>Sử dụng model Davinci.
     * @param question một chuỗi câu hỏi bất kỳ mà bạn thắc mắc. Câu hỏi càng dài thì càng tốn nhiều token.<br>
     * @param maxTokens là giới hạn token tối đa sẽ trả lại. Các model khác chỉ có 2048 trong khi Davinci là 4000.<br>
     * @return một chuỗi mà model lựa chọn trả lời cho câu hỏi của bạn.
     * @see ChatGPT#Chat(java.lang.String, com.AnLa.OpenAI.ChatGPT.Model, int) 
     */
    public final String Chat(String question, int maxTokens){
        return Chat(question, Model.Davinci, maxTokens);
    }

    
    /**Sử dụng phương thức này để trò chuyện với bot ChatGPT, chỉ cần đặt câu hỏi,
     * yêu cầu model sẽ trả lời bạn
     * và bạn sẽ nhận được phản hồi từ bot chatGPT.<br>Sử dụng tối đa 256 mã thông báo.
     * @param question một chuỗi câu hỏi bất kỳ mà bạn thắc mắc. Câu hỏi càng dài thì càng tốn nhiều token.<br>
     * @param model là model sẽ trả lời câu hỏi của bạn. Ada là người nhanh nhất, trong khi Davinci là người mạnh mẽ nhất.<br>
     * @return một chuỗi mà model lựa chọn trả lời cho câu hỏi của bạn.
     * @see ChatGPT#Chat(java.lang.String, com.AnLa.OpenAI.ChatGPT.Model, int) 
     */
    public final String Chat(String question, Model model){
        return Chat(question, model, 256);
    }

    
    /**Sử dụng phương thức này để trò chuyện với bot ChatGPT, chỉ cần đặt câu hỏi,
     * yêu cầu model sẽ trả lời bạn,
     * nhập token tối đa sẽ trả lại
     * và bạn sẽ nhận được phản hồi từ bot chatGPT.
     * @param question một chuỗi câu hỏi bất kỳ mà bạn thắc mắc. Câu hỏi càng dài thì càng tốn nhiều token.<br>
     * @param model là model sẽ trả lời câu hỏi của bạn. Ada là người nhanh nhất, trong khi Davinci là người mạnh mẽ nhất.<br>
     * @param maxTokens là giới hạn token tối đa sẽ trả lại. Các model khác chỉ có 2048 trong khi Davinci là 4000.<br>
     * @return một chuỗi mà model lựa chọn trả lời cho câu hỏi của bạn.
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