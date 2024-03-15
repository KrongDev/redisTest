package me.whiteship.redistest.test;

import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class TestService {
    //
    private final RedisTemplate<String, String> redisTemplate;

    public void create(String key, String data) {
        ValueOperations<String, String> opreation = redisTemplate.opsForValue();
        opreation.set(key, data);
    }

    public void update(String key, String data) {
        ValueOperations<String, String> opreation = redisTemplate.opsForValue();
        opreation.set(key, data);
    }

    public String load(String key) {
        ValueOperations<String, String> opreation = redisTemplate.opsForValue();
        return opreation.get(key);
    }

    public void remove(String key) {
        redisTemplate.delete(key);
    }
}
