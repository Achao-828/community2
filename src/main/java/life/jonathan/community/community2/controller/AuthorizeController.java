package life.jonathan.community.community2.controller;

import life.jonathan.community.community2.dto.AccessTokenDTO;
import life.jonathan.community.community2.dto.GithubUser;
import life.jonathan.community.community2.provider.GithubProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @PackageName: life.jonathan.community.community2.controller
 * @ClassName: AuthorizeController
 * @Description:
 * @Author: Jonathan
 * @Date: 2019/12/16 11:50
 */
@Controller
public class AuthorizeController {

    @Autowired
    private GithubProvider githubProvider;

    /**
     * 点击登录访问到GItHub，返回http://localhost:8887/callback?code=46cef1bc54c40519ac0a&state=1地址，
     * 访问https://github.com/login/oauth/access_token并携带相关参数去获取AccessToken，
     * 并通过https://api.github.com/user?access_token使用accessToken去获取user信息
     * @param code
     * @param state
     * @return
     */
    @GetMapping("/callback")
    public String callback(@RequestParam(name = "code") String code,
                           @RequestParam(name = "state") String state){
        AccessTokenDTO accessTokenDTO = new AccessTokenDTO();
        accessTokenDTO.setClient_id("49c58919931752bdb607");
        accessTokenDTO.setClient_secret("6171074c7af8f3b0353c8874311a1075d759e4a4");
        accessTokenDTO.setCode(code);
        accessTokenDTO.setRedirect_uri("http://localhost:8887/callback");
        accessTokenDTO.setState(state);
        String accessToken = githubProvider.getAccessToken(accessTokenDTO);
        GithubUser user = githubProvider.getUser(accessToken);
        System.out.println(user.getName());
        return "index";
    }
}
