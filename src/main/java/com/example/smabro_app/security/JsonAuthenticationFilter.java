package com.example.smabro_app.security;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.example.smabro_app.presentation.dto.request.LoginUserRequest;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

public class JsonAuthenticationFilter extends UsernamePasswordAuthenticationFilter {

    private AuthenticationManager authenticationManager;

    public JsonAuthenticationFilter(AuthenticationManager authenticationManager){

        // AuthenticationManagerの設定
        this.authenticationManager = authenticationManager;

        // ログインパスを設定
        setRequiresAuthenticationRequestMatcher(new AntPathRequestMatcher("/api/login","POST"));
        // ログイン用パラメータの設定
        setUsernameParameter("username");
        setPasswordParameter("password");

        // ログイン成功時はtokenを発行してレスポンスにセットする
        this.setAuthenticationSuccessHandler((request,response,ex) -> {
            // トークンの作成
            String token = JWT.create()
                    .withIssuer("com.volkruss.toaru") //発行者
                    .withClaim("username", ex.getName()) //keyに対してvalueの設定。汎用的な様々な値を保持できる
                    .sign(Algorithm.HMAC256("secret")); // 利用アルゴリズムを指定してJWTを新規作成
            response.setHeader("X-AUTH-TOKEN", token); // tokeをX-AUTH-TOKENというKeyにセットする
            response.setStatus(200);

//            RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();
//            redirectStrategy.sendRedirect(request, response, "http://localhost:8081/home");
        });

        // ログイン失敗時
        this.setAuthenticationFailureHandler((req,res,ex) -> {
            res.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
        });
    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {

        try {
            ServletInputStream stream = request.getInputStream();
            // リクエストのjsonの値をUserFormにマッピングします。
            LoginUserRequest loginUserRequest = new ObjectMapper().readValue(stream, LoginUserRequest.class);
            // これでデフォルトのProviderを利用しつつ、ユーザーレコードの取得に関してはUserDetailsServiceの実装クラスのloadUserByUsernameを利用する
            return this.authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            loginUserRequest.getUsername(),
                            loginUserRequest.getPassword(),
                            new ArrayList<>())
            );
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
