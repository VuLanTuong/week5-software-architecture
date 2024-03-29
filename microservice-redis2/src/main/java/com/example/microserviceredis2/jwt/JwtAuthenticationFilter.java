//package com.example.microserviceredis2.jwt;
//
//import com.example.microserviceredis2.model.StudentUserDetails;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.filter.OncePerRequestFilter;
//
//@Slf4j
//public class JwtAuthenticationFilter extends OncePerRequestFilter {
//    @Autowired
//    private JwtTokenProvider tokenProvider;
//
//    @Autowired
//    private StudentUserDetails studentUserDetails;
//    @Override
//    protected void doFilterInternal(HttpServletRequest request,
//                                    HttpServletResponse response, FilterChain filterChain)
//            throws ServletException, IOException {
//        try {
//            // Lấy jwt từ request
//            String jwt = getJwtFromRequest(request);
//
//            if (StringUtils.hasText(jwt) && tokenProvider.validateToken(jwt)) {
//                // Lấy id user từ chuỗi jwt
//                Long userId = tokenProvider.getUserIdFromJWT(jwt);
//                // Lấy thông tin người dùng từ id
//                UserDetails userDetails = customUserDetailsService.loadUserById(userId);
//                if(userDetails != null) {
//                    // Nếu người dùng hợp lệ, set thông tin cho Seturity Context
//                    UsernamePasswordAuthenticationToken
//                            authentication = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
//                    authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
//
//                    SecurityContextHolder.getContext().setAuthentication(authentication);
//                }
//            }
//        } catch (Exception ex) {
//            log.error("failed on set user authentication", ex);
//        }
//
//        filterChain.doFilter(request, response);
//    }
//
//    private String getJwtFromRequest(HttpServletRequest request) {
//        String bearerToken = request.getHeader("Authorization");
//        // Kiểm tra xem header Authorization có chứa thông tin jwt không
//        if (StringUtils.hasText(bearerToken) && bearerToken.startsWith("Bearer ")) {
//            return bearerToken.substring(7);
//        }
//        return null;
//    }
//}
//
