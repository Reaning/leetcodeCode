/*
 * @lc app=leetcode.cn id=295 lang=cpp
 *
 * [295] 数据流的中位数
 */
#include<bits/stdc++.h>
using namespace std;

// @lc code=start
class MedianFinder {
public:
    /** initialize your data structure here. */
    priority_queue<int,vector<int>,greater<int>>_less;
    priority_queue<int,vector<int>,less<int>>greater;
    int n = 0;
    MedianFinder() {

    }
    
    void addNum(int num) {
        if(n % 2){
            if(_less.top() < num){
                int temp = _less.top();
                _less.pop();
                greater.push(temp);
                _less.push(num);
            }else{
                greater.push(num);
            }
        }else{
            if(_less.empty())_less.push(num);
            else if(greater.top() > num){
                int temp = greater.top();
                greater.pop();
                _less.push(temp);
                greater.push(num);
            }else{
                _less.push(num);
            }
        }
        n++;
    }
    
    double findMedian() {
        if(n%2 == 0){
            return ((double)_less.top() + (double)greater.top())/2;
        }
        return _less.top();
    }
};

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder* obj = new MedianFinder();
 * obj->addNum(num);
 * double param_2 = obj->findMedian();
 */
// @lc code=end

