package com.redis;

import redis.clients.jedis.Jedis;

public class RedisTool {
    private static final String LOCK_SUCCESS = "OK";
    private static final String SET_IF_NOT_EXIST = "NX";
    private static final String SET_WITH_EXPIRE_TIME = "PX";

    /**
     * ���Ի�ȡ�ֲ�ʽ��
     *
     * @param jedis      Redis�ͻ���
     * @param lockKey    ��:����ʹ��key����������Ϊkey��Ψһ��
     * @param requestId  �����ʶ:requestId���ܶ�ͯЬ���ܲ����ף���key��Ϊ�����͹�����Ϊʲô��Ҫ�õ�value��ԭ��������������潲���ɿ���ʱ���ֲ�ʽ��Ҫ������ĸ��������廹��ϵ���ˣ�ͨ����value��ֵΪrequestId�����Ǿ�֪����������ĸ�����ӵ��ˣ��ڽ�����ʱ��Ϳ��������ݡ�
     *                   requestId����ʹ��UUID.randomUUID().toString()��������
     * @param expireTime ����ʱ��
     * @return �Ƿ��ȡ�ɹ�
     */
    public static boolean tryGetDistributedLock(Jedis jedis, String lockKey, String requestId, int expireTime) {
        /**
         * SET_IF_NOT_EXIST :NX����˼��SET IF NOT EXIST������key������ʱ�����ǽ���set��������key�Ѿ����ڣ������κβ���
         *expx������������Ǵ�����PX����˼������Ҫ�����key��һ�����ڵ�����
         */
        String result = jedis.set(lockKey, requestId, SET_IF_NOT_EXIST, SET_WITH_EXPIRE_TIME, expireTime);
        if (LOCK_SUCCESS.equals(result)) {
            return true;
        }
        return false;
    }

    public static void wrongGetLock1(Jedis jedis, String lockKey, String requestId, int expireTime) {

        Long result = jedis.setnx(lockKey, requestId);
        if (result == 1) {
            // �����������ͻȻ���������޷����ù���ʱ�䣬����������
            jedis.expire(lockKey, expireTime);
        }
    }

    public static boolean wrongGetLock2(Jedis jedis, String lockKey, int expireTime) {
        long expires = System.currentTimeMillis() + expireTime;
        String expiresStr = String.valueOf(expires);

        // �����ǰ�������ڣ����ؼ����ɹ�
        if (jedis.setnx(lockKey, expiresStr) == 1) {
            return true;
        }
        // ��������ڣ���ȡ���Ĺ���ʱ��
        String currentValueStr = jedis.get(lockKey);
        // ������Ѿ��������ȡ���Ĺ���ʱ�䣬�͵�ǰʱ��Ƚϣ�������Ѿ����ڣ��������µĹ���ʱ�䣬���ؼ����ɹ�
        if (currentValueStr != null && Long.parseLong(currentValueStr) < System.currentTimeMillis()) {
            // ���ѹ��ڣ���ȡ��һ�����Ĺ���ʱ�䣬�������������Ĺ���ʱ��
            String oldValueStr = jedis.getSet(lockKey, expiresStr);
            if (oldValueStr != null && oldValueStr.equals(currentValueStr)) {
                // ���Ƕ��̲߳����������ֻ��һ���̵߳�����ֵ�͵�ǰֵ��ͬ��������Ȩ������
                return true;
            }
        }
        // ���������һ�ɷ��ؼ���ʧ��
        return false;
    }
}


