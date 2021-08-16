/*
 * @lc app=leetcode.cn id=1418 lang=cpp
 *
 * [1418] 点菜展示表
 */
#include<bits/stdc++.h>
using namespace std;

// @lc code=start
class Solution {
public:
    vector<vector<string>> displayTable(vector<vector<string>>& orders) {
        unordered_set<string>nameset;
        int length = orders.size();
        map<int,unordered_map<string,int>>foodcnt;
        vector<string>names;
        for(int i = 0; i < length;i++){
            int no = stoi(orders[i][1]);
            foodcnt[no][orders[i][2]]++;
            nameset.insert(orders[i][2]);
        }
        for(auto it:nameset){
            names.push_back(it);
        }
        sort(names.begin(),names.end());
        vector<string>title;
        title.push_back("Table");
        for(auto it:names){
            title.push_back(it);
        }
        vector<vector<string>>ans;
        ans.push_back(title);
        for(auto it = foodcnt.begin();it!=foodcnt.end();it++){
            vector<string>str;
            str.push_back(to_string(it->first));
            for(int i = 1;i<title.size();i++){
                str.push_back(to_string(it->second[title[i]]));
            }
            ans.push_back(str);
        }
        return ans;
    }    
};
// @lc code=end
