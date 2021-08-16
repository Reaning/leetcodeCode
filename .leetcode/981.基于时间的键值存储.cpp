/*
 * @lc app=leetcode.cn id=981 lang=cpp
 *
 * [981] 基于时间的键值存储
 */
#include<bits/stdc++.h>
using namespace std;

// @lc code=start
class TimeMap {
public:
    unordered_map<string,vector<pair<int,string>>>mp;
    /** Initialize your data structure here. */
    TimeMap() {

    }
    
    void set(string key, string value, int timestamp) {
        mp[key].emplace_back(timestamp,value);
    }
    
    string get(string key, int timestamp) {

        auto pair = upper_bound(mp[key].begin(),mp[key].end(),make_pair(timestamp,string({127})));
        if(pair != mp[key].begin()) return (pair - 1)->second;
        return "";
    }
};

/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap* obj = new TimeMap();
 * obj->set(key,value,timestamp);
 * string param_2 = obj->get(key,timestamp);
 */
// @lc code=end

