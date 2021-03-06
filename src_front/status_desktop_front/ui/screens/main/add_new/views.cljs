(ns status-desktop-front.ui.screens.main.add-new.views
  (:require-macros [status-im.utils.views :as views])
  (:require [status-desktop-front.react-native-web :as react]
            [status-desktop-front.ui.components.icons :as icons]
            [re-frame.core :as re-frame]))

(views/defview new-contact []
  (views/letsubs [new-contact-identity [:get :contacts/new-identity]
                  topic [:get :public-group-topic]]
    [react/view {:style {:flex 1 :background-color "#eef2f5"}}
     ^{:key "newcontact"}
     [react/view {:style {:height 64 :align-items :center :padding-horizontal 11 :justify-content :center}}
      [react/text {:style {:font-size 16 :color :black :font-weight "600"}}
       "Add new contact"]]
     [react/view {:style {:height 1 :background-color "#e8ebec" :margin-horizontal 16}}]
     [react/view {:style {:height     90 :margin-horizontal 16 :margin-bottom 16 :background-color :white :border-radius 12
                          :box-shadow "0 0.5px 4.5px 0 rgba(0, 0, 0, 0.04)"}}
      [react/view {:style {:flex-direction :row :margin-horizontal 16 :margin-top 16}}
       [react/view {:style {:flex 1}}
        [react/text-input {:placeholder "Contact key"
                           :on-change   (fn [e]
                                          (let [native-event (.-nativeEvent e)
                                                text (.-text native-event)]
                                            (re-frame/dispatch [:set :contacts/new-identity text])))}]]
       [react/touchable-highlight {:on-press #(re-frame/dispatch [:add-contact-handler new-contact-identity])}
        [react/view {:style {:margin-left     16 :width 30 :height 30 :border-radius 15 :background-color "#eef2f5" :align-items :center
                             :justify-content :center}}
         [icons/icon :icons/ok]]]]]
     ^{:key "publicchat"}
     [react/view {:style {:height 64 :align-items :center :padding-horizontal 11 :justify-content :center}}
      [react/text {:style {:font-size 16 :color :black :font-weight "600"}}
       "Join to public chat"]]
     [react/view {:style {:height 1 :background-color "#e8ebec" :margin-horizontal 16}}]
     [react/view {:style {:height     90 :margin-horizontal 16 :margin-bottom 16 :background-color :white :border-radius 12
                          :box-shadow "0 0.5px 4.5px 0 rgba(0, 0, 0, 0.04)"}}
      [react/view {:style {:flex-direction :row :margin-horizontal 16 :margin-top 16}}
       [react/text "#"]
       [react/view {:style {:flex 1}}
        [react/text-input {:placeholder "topic"
                           :on-change   (fn [e]
                                          (let [native-event (.-nativeEvent e)
                                                text (.-text native-event)]
                                            (re-frame/dispatch [:set :public-group-topic text])))}]]
       [react/touchable-highlight {:on-press #(re-frame/dispatch [:create-new-public-chat topic])}
        [react/view {:style {:margin-left     16 :width 30 :height 30 :border-radius 15 :background-color "#eef2f5" :align-items :center
                             :justify-content :center}}
         [icons/icon :icons/ok]]]]]]))